package xyz.playneptune.consolefilter.filter

import xyz.playneptune.consolefilter.ConsoleFilterPlugin

interface LogFilter {

    fun initialize()

    fun shouldPermitMessage(message: String): Boolean {
        var toPermit = true
        ConsoleFilterPlugin.instance.config.getStringList("Filter_Messages")
            .map(String::lowercase)
            .forEach { item ->
                if (message.lowercase().contains(item)) {
                    toPermit = false
                }
            }
        return toPermit
    }

}