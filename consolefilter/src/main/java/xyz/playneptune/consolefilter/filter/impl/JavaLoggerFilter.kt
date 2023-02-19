package xyz.playneptune.consolefilter.filter.impl

import org.bukkit.Bukkit
import xyz.playneptune.consolefilter.ConsoleFilterPlugin
import xyz.playneptune.consolefilter.filter.LogFilter
import java.util.logging.Filter
import java.util.logging.LogRecord

class JavaLoggerFilter : Filter, LogFilter {

    override fun isLoggable(record: LogRecord): Boolean = shouldPermitMessage(record.message)

    override fun initialize() {
        val serverPlugins = Bukkit.getPluginManager().plugins
        serverPlugins.forEach { plugin -> plugin.logger.filter = this }
        Bukkit.getLogger().filter = this
    }

}