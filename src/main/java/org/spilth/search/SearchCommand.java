package org.spilth.search;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import org.spilth.validators.FormatValidator;

import java.util.List;

@Parameters(commandNames = "search", commandDescription = "Searches Maven Central for dependencies")
public class SearchCommand {
    @Parameter(description = "Search term", arity = 1)
    private List<String> searchTerms;

    @Parameter(names = {"--format", "-f"}, description = "Dependency output format", validateWith = FormatValidator.class)
    private String format = "maven";

    @Parameter(names = {"--help", "-h"}, help = true)
    private boolean help = false;

    public String getFormat() {
        return format;
    }

    public String getSearchTerm() {
        return searchTerms.get(0);
    }

    public boolean isHelp() {
        return help;
    }
}
