package org.spilth.dash

import org.apache.maven.model.Dependency
import org.apache.maven.model.io.xpp3.MavenXpp3Reader
import org.codehaus.plexus.util.xml.pull.XmlPullParserException
import java.io.File
import java.io.FileReader
import java.io.IOException
import java.lang.String.format

class DashService(private val dashCommand: DashCommand) {

    fun installDocs() {
        val pomFilename = dashCommand.pomFile
        val pomFile = File(pomFilename)
        val mavenXpp3Reader = MavenXpp3Reader()

        try {
            val model = mavenXpp3Reader.read(FileReader(pomFile))
            installDocsForDependencies(model.dependencies)

        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: XmlPullParserException) {
            println("Not a valid POM file.")
        }

    }

    private fun installDocsForDependencies(dependencies: List<Dependency>) {
        for (dependency in dependencies) {
            installDocsForDependency(dependency)
        }
    }

    private fun installDocsForDependency(dependency: Dependency) {
        val groupId = dependency.groupId
        val artifactId = dependency.artifactId
        val version = dependency.version

        println(format("Requesting docs for %s:%s:%s", groupId, artifactId, version))

        val url = format(
                "dash-install://repo_name=Java Docsets&entry_name=%s:%s&version=%s",
                groupId,
                artifactId,
                version
        )

        val command = arrayOf("open", url)

        try {
            val runtime = Runtime.getRuntime()
            runtime.exec(command)

        } catch (e: IOException) {
            e.printStackTrace()
        }

        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

    }
}
