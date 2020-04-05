package org.spilth.initialize

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

import java.lang.String.format

class InitializeService(private val initializeCommand: InitializeCommand) {
    private data class Archetype(val groupId: String, val artifactId: String, val version: String)

    private val java9Archetype = Archetype(groupId = "org.spilth", artifactId = "java9-minimal-quickstart", version = "1.0.0")
    private val java8Archetype = Archetype(groupId = "org.spilth", artifactId = "java8-minimal-quickstart", version = "1.0.0")
    private val kotlinArchetype = Archetype(groupId = "org.jetbrains.kotlin", artifactId = "kotlin-archetype-jvm", version = "1.1.51")

    fun initialize() {
        val archetype: Archetype = when (initializeCommand.language) {
            "kotlin" -> kotlinArchetype
            "java8" -> java8Archetype
            else -> java9Archetype
        }

        val command = format(
                "mvn archetype:generate --batch-mode -DgroupId=%s -DartifactId=%s -DarchetypeGroupId=%s -DarchetypeArtifactId=%s -DarchetypeVersion=%s -Dmaven.multiModuleProjectDirectory=\$MAVEN_HOME",
                initializeCommand.groupId,
                initializeCommand.artifactId,
                archetype.groupId,
                archetype.artifactId,
                archetype.version
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
