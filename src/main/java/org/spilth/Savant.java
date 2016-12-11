package org.spilth;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import org.spilth.initialize.InitializeCommand;
import org.spilth.initialize.InitializeService;
import org.spilth.search.SearchCommand;
import org.spilth.search.SearchService;

import java.io.IOException;

public class Savant {

    public static void main(String[] args ) throws IOException {
        MainCommand mainCommand = new MainCommand();
        JCommander jCommander = new JCommander(mainCommand);

        SearchCommand searchCommand = new SearchCommand();
        InitializeCommand initializeCommand = new InitializeCommand();

        jCommander.addCommand("init", initializeCommand);
        jCommander.addCommand("search", searchCommand);

        try {
            jCommander.parse(args);
        } catch (ParameterException parameterException) {
            System.out.println(parameterException.getMessage());
            System.exit(1);
        }

        if (jCommander.getParsedCommand() == null) {
            System.out.println("The following commands are available: search, init");
            System.exit(1);
        }

        if (jCommander.getParsedCommand().equals("search")) {
            SearchService searchService = new SearchService(searchCommand);
            searchService.search();
        } else if (jCommander.getParsedCommand().equals("init")) {
            InitializeService initializeService = new InitializeService(initializeCommand);
            initializeService.initialize();
        }
    }
}
