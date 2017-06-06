package org.spilth;

import com.beust.jcommander.Parameter;

public class MainCommand {
    @Parameter(names = {"--help", "-h"}, help = true)
    private boolean help;

    public boolean isHelp() {
        return help;
    }
}
