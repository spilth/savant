package org.spilth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"ec", "text"})
public class Doc {
    @JsonProperty("a")
    public String artifactId;

    @JsonProperty("g")
    public String groupId;

    public String id;

    public String latestVersion;

    @JsonProperty("p")
    public String packaging;

    public String repositoryId;
    public int versionCount;
    public String timestamp;


}
