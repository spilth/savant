package org.spilth;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import org.spilth.commands.SearchCommand;
import org.spilth.services.SearchService;

import java.io.IOException;

import static java.lang.System.out;

public class Savant {

    public static void main(String[] args ) throws IOException {
        if (args.length == 0) {
            out.println("Please provide a search term.");
        } else {
            try {
                SearchCommand searchCommand = new SearchCommand();
                new JCommander(searchCommand, args);

                SearchService searchService = new SearchService(searchCommand);
                searchService.search();

            } catch (ParameterException parameterException) {
                out.println(parameterException.getMessage());
            }
        }
    }

}
