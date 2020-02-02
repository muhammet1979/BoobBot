package bot.boobbot.flight.internal

import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.flight.api.Command
import bot.boobbot.flight.api.SubCommand
import org.reflections.Reflections
import java.lang.reflect.Modifier
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.memberFunctions

class Indexer(pkg: String) {

    private val reflections = Reflections(pkg)

    fun findCommands(): List<Command> {
        return reflections.getSubTypesOf(Command::class.java)
            .filter { !Modifier.isAbstract(it.modifiers) && !it.isInterface }
            .filter { it.isAnnotationPresent(CommandProperties::class.java) }
            .map {
                val kls = it.getDeclaredConstructor().newInstance()
                val subcommands = findSubCommands(kls).associateBy { sc -> sc.name }

                kls.subcommands.putAll(subcommands)
                kls
            }
    }

    fun findSubCommands(kls: Command): List<SubCommand> {
        return kls::class.memberFunctions
            .filter { it.findAnnotation<CommandProperties>() != null }
            .map {
                val props = it.findAnnotation<CommandProperties>()!!
                val name = it.name.toLowerCase()

                SubCommand(name, props, kls, it)
            }
    }

}