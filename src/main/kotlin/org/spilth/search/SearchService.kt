package org.spilth.search

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClients.createDefault
import org.spilth.models.Doc
import org.spilth.models.Results
import java.io.IOException
import java.lang.String.format
import java.lang.System.out

class SearchService(private val searchCommand: SearchCommand) {

    @Throws(IOException::class)
    fun search() {
        val url = format(
                "http://search.maven.org/solrsearch/select?q=%s&rows=1000&wt=json",
                searchCommand.searchTerm
        )

        val httpGet = HttpGet(url)

        val httpClient = createDefault()
        val response = httpClient.execute(httpGet)

        val results = ObjectMapper().readValue(
                response.entity.content,
                Results::class.java
        )

        response.close()

        val docs = results.response!!.docs

        if (docs!!.isEmpty()) {
            out.printf("No results found for `%s`%n", searchCommand.searchTerm)
        } else {
            printResults(docs)
        }
    }

    private fun printResults(docs: List<Doc>) {
        docs.sortedBy(Doc::groupId)

        for (doc in docs) {
            if (searchCommand.format == "maven") {
                out.printf("<dependency>%n")
                out.printf("    <groupId>%s</groupId>%n", doc.groupId)
                out.printf("    <artifactId>%s</artifactId>%n", doc.artifactId)
                out.printf("    <version>%s</version>%n", doc.latestVersion)
                out.printf("</dependency>%n")
            } else {
                out.printf(
                    "compile group: '%s', name: '%s', version: '%s'%n",
                    doc.groupId,
                    doc.artifactId,
                    doc.latestVersion
                )
            }
        }
    }
}