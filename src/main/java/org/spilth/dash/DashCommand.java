package org.spilth.dash;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(commandNames = "dash", commandDescription = "Adds Maven project dependencies to Dash")
public class DashCommand {
    @Parameter(names = {"--pom", "-p", "--file", "-f"}, description = "Source POM File")
    private String pomFile = "pom.xml";

    @Parameter(names = {"--help", "-h"}, help = true)
    private boolean help = false;

    public String getPomFile() {
        return pomFile;
    }

    public boolean isHelp() {
        return help;
    }
}
