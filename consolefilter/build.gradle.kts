import kr.entree.spigradle.kotlin.*
import com.github.jengelman.gradle.plugins.shadow.tasks.*
import kr.entree.spigradle.data.Load

group = "xyz.playneptune"
version = "2023.1"

plugins {
    kotlin("jvm") version "1.8.10"
    id("kr.entree.spigradle") version "2.4.3"
    id("com.github.johnrengelman.shadow") version "8.1.0"
}

repositories {
    mavenCentral()
    bStats()
}

tasks {
    named<ShadowJar>("shadowJar") {
        mergeServiceFiles()
        exclude("org/jetbrains/**")
        exclude("org/intellij/**")
        relocate("kotlin", "xyz.playneptune.consolefilter.lib.kotlin")
        relocate("org.bstats", "xyz.playneptune.consolefilter.lib.bstats")
    }
}

tasks {
    build {
        dependsOn(shadowJar)
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF8"
}

dependencies {
    compileOnly(spigot("1.19.2"))
    implementation(kotlin("stdlib-jdk8"))
    implementation(bStatsLite("1.8"))
    compileOnly("org.apache.logging.log4j:log4j-core:2.19.0")
}

spigot {
    name = "ConsoleFilter"
    apiVersion = "1.13"
    authors = listOf("TNT10128")
    load = Load.STARTUP
    excludeLibraries("bstats", "log4j", "kotlin")
    commands {
        create("consolefilter") {
            aliases = listOf("confilter", "cf")
            description = "Main ConsoleFilter command."
            usage = "/<command> <reload|version>"
            permission = "consolefilter.command"
        }
    }
    permissions {
        create("consolefilter.command") {
            description = "Allows you to use the /consolefilter command"
        }
    }
}