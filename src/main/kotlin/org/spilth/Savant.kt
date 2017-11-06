package org.spilth

import com.beust.jcommander.JCommander
import com.beust.jcommander.ParameterException
import org.spilth.dash.DashCommand
import org.spilth.dash.DashService
import org.spilth.initialize.InitializeCommand
import org.spilth.initialize.InitializeService
import org.spilth.search.SearchCommand
import org.spilth.search.SearchService
import java.io.IOException
import java.lang.System.out
import java.util.ResourceBundle.getBundle

object Savant {
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val messages = getBundle("MessagesBundle")

        val mainCommand = MainCommand()
        val jCommander = JCommander(mainCommand)

        val searchCommand = SearchCommand()
        val initializeCommand = InitializeCommand()
        val dashCommand = DashCommand()

        jCommander.programName = messages.getString("programName")
        jCommander.addCommand(initializeCommand)
        jCommander.addCommand(searchCommand)
        jCommander.addCommand(dashCommand)

        try {
            jCommander.parse(*args)
        } catch (parameterException: ParameterException) {
            println(parameterException.message)
            System.exit(1)
        }

        if (jCommander.parsedCommand == null) {
            when {
                mainCommand.isVersion -> out.printf("%s%n", messages.getString("version"))
                mainCommand.isHelp -> jCommander.usage()
                else -> jCommander.usage()
            }
        } else {
            when {
                jCommander.parsedCommand == "search" -> {
                    if (searchCommand.isHelp) {
                        jCommander.usage("search")
                    } else {
                        val searchService = SearchService(searchCommand)
                        searchService.search()
                    }
                }

                jCommander.parsedCommand == "init" -> {
                    if (initializeCommand.isHelp) {
                        jCommander.usage("init")
                    } else {
                        val initializeService = InitializeService(initializeCommand)
                        initializeService.initialize()
                    }
                }

                jCommander.parsedCommand == "dash" -> {
                    if (dashCommand.isHelp) {
                        jCommander.usage("dash")
                    } else {
                        val dashService = DashService(dashCommand)
                        dashService.installDocs()
                    }
                }
            }
        }
    }
}
