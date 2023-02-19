package xyz.playneptune.consolefilter

import org.bstats.bukkit.MetricsLite
import org.bukkit.plugin.java.JavaPlugin
import xyz.playneptune.consolefilter.command.ConsoleFilterCommand
import xyz.playneptune.consolefilter.filter.impl.JavaLoggerFilter
import xyz.playneptune.consolefilter.filter.impl.Log4jFilter
import xyz.playneptune.consolefilter.filter.impl.StandardOutputFilter

class ConsoleFilterPlugin : JavaPlugin() {

    override fun onEnable() {
        instance = this
        initializeTelemetry()
        initializeConfiguration()
        registerCommands()
        setupFilter()
    }

    private fun initializeConfiguration() = saveDefaultConfig()

    private fun initializeTelemetry() = MetricsLite(this, METRICS_PLUGIN_ID)

    private fun registerCommands() = getCommand("consolefilter")!!.setExecutor(ConsoleFilterCommand())

    private fun setupFilter() {
        StandardOutputFilter().initialize()
        JavaLoggerFilter().initialize()
        Log4jFilter().initialize()
    }

    companion object {
        lateinit var instance: ConsoleFilterPlugin
            private set

        const val METRICS_PLUGIN_ID = 17773
    }

}