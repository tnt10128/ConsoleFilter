package xyz.playneptune.consolefilter.command

import com.google.common.collect.ImmutableList
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabExecutor
import xyz.playneptune.consolefilter.ConsoleFilterPlugin
import xyz.playneptune.consolefilter.util.sendMessage

class ConsoleFilterCommand : TabExecutor {

    private val NO_COMPLETION: ImmutableList<String> = ImmutableList.of()

    private fun sendUsageMessage(
        sender: CommandSender,
        command: Command,
        label: String = command.label
    ) {
        sendMessage(sender, "&8(&4&l✕&8)&c Usage: ${command.usage.replace("<command>", label)}")
    }

    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): Boolean {
        if (args.isEmpty()) {
            sendUsageMessage(sender, command, label)
            return true
        }
        when (args[0]) {
            "reload", "rl" -> {
                ConsoleFilterPlugin.instance.reloadConfig()
                sendMessage(sender, "&8(&2&l✔&8)&7 Configuration reloaded.")
            }

            "version", "ver" -> {
                val pluginName = ConsoleFilterPlugin.instance.name
                val pluginDescription = ConsoleFilterPlugin.instance.description
                val pluginVersion = pluginDescription.version
                val pluginAuthors = pluginDescription.authors
                val pluginPrimaryAuthor = if (pluginAuthors.isEmpty()) "TNT10128" else pluginAuthors[0]
                sendMessage(
                    sender,
                    "&8&m-----------------------------------------------------",
                    "&c&l  $pluginName &7$pluginVersion",
                    " ",
                    "   &7Made by &f$pluginPrimaryAuthor &7© 2023",
                    "   &7Running on &f${Bukkit.getName()} ${Bukkit.getVersion()}",
                    "&8&m-----------------------------------------------------"
                )
            }

            else -> sendUsageMessage(sender, command, label)
        }
        return true
    }

    private fun findEligibleCompletions(buffer: String, vararg options: String) = options.map(String::lowercase)
        .filter { option -> option.startsWith(buffer.lowercase()) }

    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): List<String> = when (args.size) {
        1 -> findEligibleCompletions(args[0], "reload", "rl", "version", "ver")
        else -> NO_COMPLETION
    }

}