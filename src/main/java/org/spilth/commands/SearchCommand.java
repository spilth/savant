package org.spilth.commands;

import com.beust.jcommander.Parameter;

import java.util.List;

public class SearchCommand {
    @Parameter(description = "Search term", arity = 1)
    private List<String> searchTerms;

    @Parameter(names = {"--format", "-f"}, description = "Dependency output format", validateWith = FormatValidator.class)
    private String format = "maven";

    public String getFormat() {
        return format;
    }

    public String getSearchTerm() {
        return searchTerms.get(0);
    }
}
