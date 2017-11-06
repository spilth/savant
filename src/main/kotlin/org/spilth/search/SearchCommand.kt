package org.spilth.search

import com.beust.jcommander.Parameter
import com.beust.jcommander.Parameters
import org.spilth.validators.FormatValidator

@Parameters(commandNames = arrayOf("search"), commandDescription = "Searches Maven Central for dependencies")
class SearchCommand {
    @Parameter(description = "Search term", arity = 1)
    private val searchTerms: List<String>? = null

    @Parameter(names = arrayOf("--format", "-f"), description = "Dependency output format", validateWith = arrayOf(FormatValidator::class))
    val format = "maven"

    @Parameter(names = arrayOf("--help", "-h"), description = "Show help", help = true)
    val isHelp = false

    val searchTerm: String
        get() = searchTerms!![0]
}
