package org.spilth.initialize;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.String.format;
import static java.lang.System.out;

public class InitializeService {
    private InitializeCommand initializeCommand;

    public InitializeService(InitializeCommand initializeCommand) {
        this.initializeCommand = initializeCommand;
    }

    public void initialize() {
        String archetypeName;
        String archetypeGroupId = "org.spilth";
        String archetypeVersion;

        switch (initializeCommand.getLanguage()) {
            case "kotlin":
                archetypeName = "kotlin-archetype-jvm";
                archetypeVersion = "1.1.51";
                archetypeGroupId = "org.jetbrains.kotlin";
                break;

            case "java8":
                archetypeName = "java8-minimal-quickstart";
                archetypeVersion = "1.0.0";
                break;

            default:
                archetypeName = "java9-minimal-quickstart";
                archetypeVersion = "1.0.0";
                break;
        }

        String command = format(
                "mvn archetype:generate --batch-mode -DgroupId=%s -DartifactId=%s -DarchetypeGroupId=%s -DarchetypeArtifactId=%s -DarchetypeVersion=%s -Dmaven.multiModuleProjectDirectory=$MAVEN_HOME",
                initializeCommand.getGroupId(),
                initializeCommand.getArtifactId(),
                archetypeGroupId,
                archetypeName,
                archetypeVersion
        );

        try {
            out.println("\u001B[32mCreating project '" + initializeCommand.getArtifactId() + "'...\u001B[0m");

            Process process = Runtime.getRuntime().exec(command);
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                out.println(line);
            }

            out.println("Project created in directory " + initializeCommand.getArtifactId());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
