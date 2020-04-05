package org.spilth.initialize

import com.beust.jcommander.Parameter
import com.beust.jcommander.Parameters
import org.spilth.validators.LanguageValidator

@Parameters(commandNames = ["init"], commandDescription = "Initializes a new Maven project")
class InitializeCommand {
    @Parameter(names = ["--groupId", "--group", "-g"], description = "Group ID")
    var groupId = "com.example"

    @Parameter(description = "Artifact ID", required = true)
    var artifactId: String? = null

    @Parameter(names = ["--language", "-l"], description = "Language (java, java8 or kotlin)", required = true, validateWith = [LanguageValidator::class])
    var language: String? = null

    @Parameter(names = ["--help", "-h"], description = "Show help", help = true)
    var isHelp = false
}
