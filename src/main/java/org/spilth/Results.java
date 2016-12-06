package org.spilth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"responseHeader", "spellcheck"})
public class Results {
    public Response response;
}
