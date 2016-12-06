package org.spilth;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.List;

import static java.lang.System.out;
import static java.util.Comparator.comparing;

public class App {
    public static void main( String[] args ) throws IOException {
        if (args.length == 0) {
            out.println("Please provide a search term.");
        } else {
            performSearch(args[0]);
        }
    }

    private static void performSearch(String search) throws IOException {
        String url = String.format(
                "http://search.maven.org/solrsearch/select?q=%s&rows=1000&wt=json",
                search
        );

        HttpGet httpGet = new HttpGet(url);

        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = httpClient.execute(httpGet);

        ObjectMapper mapper = new ObjectMapper();
        Results results = mapper.readValue(response.getEntity().getContent(), Results.class);

        List<Doc> docs = results.response.docs;
        docs.sort(comparing(d -> d.groupId));

        for (Doc doc : docs) {
            out.println("<dependency>");
            out.printf("    <groupId>%s</groupId>%n", doc.groupId);
            out.printf("    <artifactId>%s</artifactId>%n", doc.artifactId);
            out.printf("    <version>%s</version>%n", doc.latestVersion);
            out.println("</dependency>");
        }

        response.close();
    }
}
