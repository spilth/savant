package org.spilth.dash;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static java.lang.String.format;
import static java.lang.System.out;

public class DashService {
    private DashCommand dashCommand;

    public DashService(DashCommand dashCommand) {
        this.dashCommand = dashCommand;
    }

    public void initialize() {
        String pomFilename = dashCommand.getPomFile();

        MavenXpp3Reader mavenXpp3Reader = new MavenXpp3Reader();

        File pomFile = new File(pomFilename);

        try {
            Model model = mavenXpp3Reader.read(new FileReader(pomFile));
            installDocsForDependencies(model.getDependencies());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            System.out.println("Not a valid POM file.");
        }

    }

    private void installDocsForDependencies(List<Dependency> dependencies) {
        for (Dependency dependency: dependencies) {
            installDocsForDependency(dependency);
        }
    }

    private void installDocsForDependency(Dependency dependency) {
        String groupId = dependency.getGroupId();
        String artifactId = dependency.getArtifactId();
        String version = dependency.getVersion();

        out.println(format("Requesting docs for %s:%s:%s", groupId, artifactId, version));

        String url = format(
                "dash-install://repo_name=Java Docsets&entry_name=%s:%s&version=%s",
                groupId,
                artifactId,
                version
        );

        String[] command = {"open", url};

        try {
            Runtime runtime = Runtime.getRuntime();
            runtime.exec(command);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
