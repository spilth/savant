package org.spilth;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import org.spilth.dash.DashCommand;
import org.spilth.dash.DashService;
import org.spilth.initialize.InitializeCommand;
import org.spilth.initialize.InitializeService;
import org.spilth.search.SearchCommand;
import org.spilth.search.SearchService;

import java.io.IOException;

import static java.lang.System.out;

public class Savant {
    public static void main(String[] args ) throws IOException {
        MainCommand mainCommand = new MainCommand();
        JCommander jCommander = new JCommander(mainCommand);

        SearchCommand searchCommand = new SearchCommand();
        InitializeCommand initializeCommand = new InitializeCommand();
        DashCommand dashCommand = new DashCommand();

        jCommander.addCommand("init", initializeCommand);
        jCommander.addCommand("search", searchCommand);
        jCommander.addCommand("dash", dashCommand);

        try {
            jCommander.parse(args);
        } catch (ParameterException parameterException) {
            out.println(parameterException.getMessage());
            System.exit(1);
        }

        if (jCommander.getParsedCommand() == null) {
            out.println("usage: savant command [options]");
            out.println();
            out.println("The following commands are available: init, dash, search");
            out.println();
        } else {
            if (jCommander.getParsedCommand().equals("search")) {
                SearchService searchService = new SearchService(searchCommand);
                searchService.search();
            } else if (jCommander.getParsedCommand().equals("init")) {
                InitializeService initializeService = new InitializeService(initializeCommand);
                initializeService.initialize();
            } else if (jCommander.getParsedCommand().equals("dash")) {
                DashService dashService = new DashService(dashCommand);
                dashService.initialize();
            }
        }
    }
}
