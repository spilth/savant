package org.spilth.validators;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

import java.util.Arrays;
import java.util.List;

public class LanguageValidator implements IParameterValidator {
    public static final List<String> VALID_TYPES = Arrays.asList("java", "kotlin");

    @Override
    public void validate(String name, String value) throws ParameterException {
        if (!VALID_TYPES.contains(value)) {
            throw new ParameterException(String.format("Parameter %s needs to be either `java` or `kotlin`.", name));
        }
    }
}
