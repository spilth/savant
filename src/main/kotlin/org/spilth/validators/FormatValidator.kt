package org.spilth.validators

import com.beust.jcommander.IParameterValidator
import com.beust.jcommander.ParameterException
import java.util.*

class FormatValidator : IParameterValidator {

    @Throws(ParameterException::class)
    override fun validate(name: String, value: String) {
        if (!VALID_FORMATS.contains(value)) {
            throw ParameterException(String.format("Parameter %s needs to be either `maven` or `gradle`.", name))
        }
    }

    companion object {
        val VALID_FORMATS = Arrays.asList("maven", "gradle")
    }
}
