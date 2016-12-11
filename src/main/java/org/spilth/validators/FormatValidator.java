package org.spilth.validators;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

import java.util.Arrays;
import java.util.List;

public class FormatValidator implements IParameterValidator {
    public static final List<String> VALID_FORMATS = Arrays.asList("maven", "gradle");

    @Override
    public void validate(String name, String value) throws ParameterException {
        if (!VALID_FORMATS.contains(value)) {
            throw new ParameterException(String.format("Parameter %s needs to be either `maven` or `gradle`.", name));
        }
    }
}
