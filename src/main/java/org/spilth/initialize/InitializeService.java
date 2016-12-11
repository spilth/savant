package org.spilth.initialize;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.out;

public class InitializeService {
    private InitializeCommand initializeCommand;

    public InitializeService(InitializeCommand initializeCommand) {
        this.initializeCommand = initializeCommand;
    }

    public void initialize() {
        String command = String.format(
                "mvn archetype:generate -DgroupId=%s -DartifactId=%s -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false -Dmaven.multiModuleProjectDirectory=$MAVEN_HOME",
                initializeCommand.getGroupId(),
                initializeCommand.getArtifactId()
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
