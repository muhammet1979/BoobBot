package bot.boobbot.internals

import bot.boobbot.BoobBot
import bot.boobbot.flight.api.Command
import bot.boobbot.flight.api.SubCommand
import bot.boobbot.flight.internal.Indexer

class CommandRegistry(
    private val commands: Map<String, Command>
) : Map<String, Command> by commands {

    init {
        BoobBot.log.info("Successfully loaded ${commands.size} commands!")
    }

    fun findCommand(commandName: String): Command? {
        return commands[commandName]
            ?: values.firstOrNull { it.properties().aliases.contains(commandName) }
    }

    fun findSubCommand(commandName: String, command: Command): SubCommand? {
        return command.subcommands[commandName]
            ?: command.subcommands.values.firstOrNull { it.properties.aliases.contains(commandName) }
    }

    companion object {
        fun load(): CommandRegistry {
            val indexer = Indexer("bot.boobbot.commands")
            val commands = indexer.findCommands().associateBy { it.name() }
            return CommandRegistry(commands)
        }
    }

}