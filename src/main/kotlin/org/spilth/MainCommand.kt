package org.spilth

import com.beust.jcommander.Parameter

class MainCommand {
    @Parameter(names = arrayOf("--version", "-v"), description = "Display the version of savant", help = true)
    val isVersion: Boolean = false

    @Parameter(names = arrayOf("--help", "-h"), description = "Display help for savant", help = true)
    val isHelp: Boolean = false
}
