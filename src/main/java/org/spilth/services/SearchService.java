package org.spilth.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.spilth.models.Doc;
import org.spilth.models.Results;

import java.io.IOException;
import java.util.List;

import static java.lang.String.format;
import static java.lang.System.out;
import static java.util.Comparator.comparing;
import static org.apache.http.impl.client.HttpClients.createDefault;

public class SearchService {
    public void search(String searchTerm) throws IOException {
        String url = format(
                "http://search.maven.org/solrsearch/select?q=%s&rows=1000&wt=json",
                searchTerm
        );

        HttpGet httpGet = new HttpGet(url);

        CloseableHttpClient httpClient = createDefault();
        CloseableHttpResponse response = httpClient.execute(httpGet);

        Results results = new ObjectMapper().readValue(
                response.getEntity().getContent(),
                Results.class
        );

        List<Doc> docs = results.getResponse().getDocs();
        docs.sort(comparing(Doc::getGroupId));

        for (Doc doc : docs) {
            out.printf("<dependency>%n");
            out.printf("    <groupId>%s</groupId>%n", doc.getGroupId());
            out.printf("    <artifactId>%s</artifactId>%n", doc.getArtifactId());
            out.printf("    <version>%s</version>%n", doc.getLatestVersion());
            out.printf("</dependency>%n");
        }

        response.close();
    }
}