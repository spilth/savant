package org.spilth.dash

import com.beust.jcommander.Parameter
import com.beust.jcommander.Parameters

@Parameters(commandNames = arrayOf("dash"), commandDescription = "Adds Maven project dependencies to Dash")
class DashCommand {
    @Parameter(names = arrayOf("--pom", "-p", "--file", "-f"), description = "Source POM File")
    var pomFile = "pom.xml"

    @Parameter(names = arrayOf("--help", "-h"), description = "Show help", help = true)
    var isHelp = false
}
