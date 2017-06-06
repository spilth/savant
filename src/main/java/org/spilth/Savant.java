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

        jCommander.setProgramName("savant");
        jCommander.addCommand(initializeCommand);
        jCommander.addCommand(searchCommand);
        jCommander.addCommand(dashCommand);

        try {
            jCommander.parse(args);
        } catch (ParameterException parameterException) {
            out.println(parameterException.getMessage());
            System.exit(1);
        }

        if (jCommander.getParsedCommand() == null) {
            jCommander.usage();
        } else {
            if (jCommander.getParsedCommand().equals("search")) {
                if (searchCommand.isHelp()) {
                    jCommander.usage("search");
                } else {
                    SearchService searchService = new SearchService(searchCommand);
                    searchService.search();
                }
            } else if (jCommander.getParsedCommand().equals("init")) {
                if (initializeCommand.isHelp()) {
                    jCommander.usage("init");
                } else {
                    InitializeService initializeService = new InitializeService(initializeCommand);
                    initializeService.initialize();
                }
            } else if (jCommander.getParsedCommand().equals("dash")) {
                if (dashCommand.isHelp()) {
                    jCommander.usage("dash");
                } else {
                    DashService dashService = new DashService(dashCommand);
                    dashService.installDocs();
                }
            }
        }
    }
}
