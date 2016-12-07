package org.spilth.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.spilth.commands.SearchCommand;
import org.spilth.models.Doc;
import org.spilth.models.Results;

import java.io.IOException;
import java.util.List;

import static java.lang.String.format;
import static java.lang.System.out;
import static java.util.Comparator.comparing;
import static org.apache.http.impl.client.HttpClients.createDefault;

public class SearchService {
    private final SearchCommand searchCommand;

    public SearchService(SearchCommand searchCommand) {
        this.searchCommand = searchCommand;
    }

    public void search() throws IOException {
        String url = format(
                "http://search.maven.org/solrsearch/select?q=%s&rows=1000&wt=json",
                searchCommand.getSearchTerm()
        );

        HttpGet httpGet = new HttpGet(url);

        CloseableHttpClient httpClient = createDefault();
        CloseableHttpResponse response = httpClient.execute(httpGet);

        Results results = new ObjectMapper().readValue(
                response.getEntity().getContent(),
                Results.class
        );

        response.close();

        List<Doc> docs = results.getResponse().getDocs();

        if (docs.isEmpty()) {
            out.printf("No results found for `%s`%n", searchCommand.getSearchTerm());
        } else {
            printResults(docs);
        }
    }

    private void printResults(List<Doc> docs) {
        docs.sort(comparing(Doc::getGroupId));

        for (Doc doc : docs) {
            if (searchCommand.getFormat().equals("maven")) {
                out.printf("<dependency>%n");
                out.printf("    <groupId>%s</groupId>%n", doc.getGroupId());
                out.printf("    <artifactId>%s</artifactId>%n", doc.getArtifactId());
                out.printf("    <version>%s</version>%n", doc.getLatestVersion());
                out.printf("</dependency>%n");
            } else {
                out.printf(
                        "compile group: '%s', name: '%s', version: '%s'%n",
                        doc.getGroupId(),
                        doc.getArtifactId(),
                        doc.getLatestVersion()
                );
            }
        }
    }
}