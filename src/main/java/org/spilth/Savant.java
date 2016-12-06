package org.spilth;

import org.spilth.services.SearchService;

import java.io.IOException;

import static java.lang.System.out;

public class Savant {

    public static void main(String[] args ) throws IOException {
        if (args.length == 0) {
            out.println("Please provide a search term.");
        } else {
            SearchService searchService = new SearchService();
            searchService.search(args[0]);
        }
    }

}
