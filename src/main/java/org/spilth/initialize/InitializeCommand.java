package org.spilth.initialize;

import com.beust.jcommander.Parameter;

public class InitializeCommand {
    @Parameter(names = {"--groupId", "-g"}, description = "Group ID")
    private String groupId = "com.example";

    @Parameter(names = {"--artifactId", "-a"}, description = "Artifact ID")
    private String artifactId = "exampleArtifact";

    public String getGroupId() {
        return groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }
}