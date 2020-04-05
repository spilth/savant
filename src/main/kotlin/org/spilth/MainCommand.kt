package org.spilth

import com.beust.jcommander.Parameter

class MainCommand {
    @Parameter(names = ["--version", "-v"], description = "Display the version of savant", help = true)
    var isVersion: Boolean = false

    @Parameter(names = ["--help", "-h"], description = "Display help for savant", help = true)
    var isHelp: Boolean = false
}
