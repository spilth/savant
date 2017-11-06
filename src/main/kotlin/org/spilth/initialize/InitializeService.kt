package org.spilth.initialize

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

import java.lang.String.format

class InitializeService(private val initializeCommand: InitializeCommand) {

    fun initialize() {
        val archetypeName: String
        var archetypeGroupId = "org.spilth"
        val archetypeVersion: String

        when (initializeCommand.language) {
            "kotlin" -> {
                archetypeName = "kotlin-archetype-jvm"
                archetypeVersion = "1.1.51"
                archetypeGroupId = "org.jetbrains.kotlin"
            }

            "java8" -> {
                archetypeName = "java8-minimal-quickstart"
                archetypeVersion = "1.0.0"
            }

            else -> {
                archetypeName = "java9-minimal-quickstart"
                archetypeVersion = "1.0.0"
            }
        }

        val command = format(
                "mvn archetype:generate --batch-mode -DgroupId=%s -DartifactId=%s -DarchetypeGroupId=%s -DarchetypeArtifactId=%s -DarchetypeVersion=%s -Dmaven.multiModuleProjectDirectory=\$MAVEN_HOME",
                initializeCommand.groupId,
                initializeCommand.artifactId,
                archetypeGroupId,
                archetypeName,
                archetypeVersion
        )

        try {
            println("\u001B[32mCreating project '" + initializeCommand.artifactId + "'...\u001B[0m")

            val process = Runtime.getRuntime().exec(command)
            val bufferedReader = BufferedReader(
                    InputStreamReader(process.inputStream)
            )

            bufferedReader.use {
                println(it.readText())
            }

            println("Project created in directory " + initializeCommand.artifactId)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
