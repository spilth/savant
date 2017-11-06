package org.spilth.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties
class Response {
    var numFound: Int = 0
    var start: Int = 0

    var docs: List<Doc>? = null
}
