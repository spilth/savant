package org.spilth.initialize

import com.beust.jcommander.Parameter
import com.beust.jcommander.Parameters
import org.spilth.validators.LanguageValidator

@Parameters(commandNames = arrayOf("init"), commandDescription = "Initializes a new Maven project")
class InitializeCommand {
    @Parameter(names = arrayOf("--groupId", "--group", "-g"), description = "Group ID")
    var groupId = "com.example"

    @Parameter(names = arrayOf("--artifactId", "--artifact", "-a"), description = "Artifact ID")
    var artifactId = "exampleArtifact"

    @Parameter(names = arrayOf("--language", "-l"), description = "Project Language (java, java8 or kotlin)", required = true, validateWith = arrayOf(LanguageValidator::class))
    var language = ""

    @Parameter(names = arrayOf("--help", "-h"), description = "Show help", help = true)
    var isHelp = false
}
