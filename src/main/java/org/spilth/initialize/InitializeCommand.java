package org.spilth.initialize;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(commandNames = "init", commandDescription = "Initializes a new Java 8 Maven project")
public class InitializeCommand {
    @Parameter(names = {"--groupId", "--group", "-g"}, description = "Group ID")
    private String groupId = "com.example";

    @Parameter(names = {"--artifactId", "--artifact", "-a"}, description = "Artifact ID")
    private String artifactId = "exampleArtifact";

    @Parameter(names = {"--minimal", "-m"}, description = "Use Minimal Java 8 Archetype")
    private boolean minimal = false;

    @Parameter(names = {"--help", "-h"}, help = true)
    private boolean help = false;

    public String getGroupId() {
        return groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public boolean isMinimal() {
        return minimal;
    }

    public boolean isHelp() {
        return help;
    }
}
