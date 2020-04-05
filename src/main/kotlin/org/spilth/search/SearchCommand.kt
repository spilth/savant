package org.spilth.search

import com.beust.jcommander.Parameter
import com.beust.jcommander.Parameters
import org.spilth.validators.FormatValidator

@Parameters(commandNames = ["search"], commandDescription = "Searches Maven Central for dependencies")
class SearchCommand {
    @Parameter(description = "Search Term", required = true)
    var searchTerm: String? = null

    @Parameter(names = ["--format", "-f"], description = "Dependency output format: maven (default) or gradle", validateWith = [FormatValidator::class])
    var format = "maven"

    @Parameter(names = ["--help", "-h"], description = "Show help", help = true)
    var isHelp = false
}
