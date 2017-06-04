package org.spilth.dash;

import com.beust.jcommander.Parameter;

public class DashCommand {
    @Parameter(names = {"--pom", "-p", "--file", "-f"}, description = "Source POM File")
    private String pomFile = "pom.xml";

    public String getPomFile() {
        return pomFile;
    }
}
