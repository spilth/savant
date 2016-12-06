package org.spilth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties()
public class Response {
    public int numFound;
    public int start;

    public List<Doc> docs;
}
