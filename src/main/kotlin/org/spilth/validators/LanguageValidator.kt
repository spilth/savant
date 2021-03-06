package org.spilth.validators

import com.beust.jcommander.IParameterValidator
import com.beust.jcommander.ParameterException
import java.util.*

class LanguageValidator : IParameterValidator {

    @Throws(ParameterException::class)
    override fun validate(name: String, value: String) {
        if (!VALID_TYPES.contains(value)) {
            throw ParameterException(String.format("Parameter %s needs to be either `java`, `java8`, or `kotlin`.", name))
        }
    }

    companion object {
        val VALID_TYPES = Arrays.asList("java", "java8", "kotlin")
    }
}
