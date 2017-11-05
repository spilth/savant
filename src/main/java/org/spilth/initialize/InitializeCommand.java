package org.spilth.initialize;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import org.spilth.validators.LanguageValidator;

@Parameters(commandNames = "init", commandDescription = "Initializes a new Maven project")
public class InitializeCommand {
    @Parameter(names = {"--groupId", "--group", "-g"}, description = "Group ID")
    private String groupId = "com.example";

    @Parameter(names = {"--artifactId", "--artifact", "-a"}, description = "Artifact ID")
    private String artifactId = "exampleArtifact";

    @Parameter(names = {"--language", "-l"}, description = "Project Language (java, java8 or kotlin)", validateWith = LanguageValidator.class)
    private String language = "java";

    @Parameter(names = {"--help", "-h"}, description = "Show help", help = true)
    private boolean help = false;

    public String getGroupId() {
        return groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public String getLanguage() {
        return language;
    }

    public boolean isHelp() {
        return help;
    }
}
