package org.spilth.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties("responseHeader", "spellcheck")
class Results {
    var response: Response? = null
}
