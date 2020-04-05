package org.spilth.dash

import com.beust.jcommander.Parameter
import com.beust.jcommander.Parameters

@Parameters(commandNames = ["dash"], commandDescription = "Adds Maven project dependencies to Dash")
class DashCommand {
    @Parameter(names = ["--pom", "-p", "--file", "-f"], description = "Source POM File")
    var pomFile = "pom.xml"

    @Parameter(names = ["--help", "-h"], description = "Show help", help = true)
    var isHelp = false
}
