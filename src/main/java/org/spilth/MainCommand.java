package org.spilth;

import com.beust.jcommander.Parameter;

public class MainCommand {
    @Parameter(names = {"--version", "-v"}, description = "Display the version of savant")
    private boolean version;

    @Parameter(names = {"--help", "-h"}, description = "Display help for savant", help = true)
    private boolean help;

    public boolean isHelp() {
        return help;
    }

    public boolean isVersion() {
        return version;
    }
}
