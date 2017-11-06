package org.spilth.search

import com.beust.jcommander.Parameter
import com.beust.jcommander.Parameters
import org.spilth.validators.FormatValidator

@Parameters(commandNames = arrayOf("search"), commandDescription = "Searches Maven Central for dependencies")
class SearchCommand {
    @Parameter(description = "Search term", arity = 1)
    var searchTerms: List<String>? = null

    @Parameter(names = arrayOf("--format", "-f"), description = "Dependency output format", validateWith = arrayOf(FormatValidator::class))
    var format = "maven"

    @Parameter(names = arrayOf("--help", "-h"), description = "Show help", help = true)
    var isHelp = false

    val searchTerm: String
        get() = searchTerms!![0]
}
