package org.spilth.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties("ec", "text")
class Doc {
    @JsonProperty("a")
    var artifactId: String? = null

    @JsonProperty("g")
    var groupId: String? = null

    var id: String? = null

    var latestVersion: String? = null

    @JsonProperty("p")
    var packaging: String? = null

    var repositoryId: String? = null
    var versionCount: Int = 0
    var timestamp: String? = null
}
