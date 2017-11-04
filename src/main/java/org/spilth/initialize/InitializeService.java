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

        if (initializeCommand.isMinimal()) {
            archetypeName = "java8-minimal-quickstart";
            archetypeVersion = "1.0.0";
        } else {
            if (initializeCommand.getLanguage().equals("kotlin")) {
                archetypeName = "kotlin-archetype-jvm";
                archetypeVersion = "1.1.51";
                archetypeGroupId = "org.jetbrains.kotlin";
            } else {
                archetypeName = "java8-junit4-quickstart";
                archetypeVersion = "1.0.2";
            }
        }

        String command = format(
                "mvn archetype:generate -DgroupId=%s -DartifactId=%s -DarchetypeGroupId=%s -DarchetypeArtifactId=%s -DarchetypeVersion=%s -B -Dmaven.multiModuleProjectDirectory=$MAVEN_HOME",
                initializeCommand.getGroupId(),
                initializeCommand.getArtifactId(),
                archetypeGroupId,
                archetypeName,
                archetypeVersion
        );

        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
