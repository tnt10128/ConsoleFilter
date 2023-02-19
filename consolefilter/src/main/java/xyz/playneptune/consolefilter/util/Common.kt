package xyz.playneptune.consolefilter.util

import org.bukkit.ChatColor
import org.bukkit.command.CommandSender

fun colorize(textToColorize: String) = ChatColor.translateAlternateColorCodes('&', textToColorize)

fun sendMessage(recipient: CommandSender, vararg messages: String) = messages.map(::colorize)
    .forEach { message -> recipient.sendMessage(message) }