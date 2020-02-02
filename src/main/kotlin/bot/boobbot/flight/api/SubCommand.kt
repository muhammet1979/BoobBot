package bot.boobbot.flight.api

import bot.boobbot.BoobBot
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.flight.internal.Executable
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KParameter
import kotlin.reflect.full.callSuspend
import kotlin.reflect.full.instanceParameter

class SubCommand(
    val name: String,
    val properties: CommandProperties,
    private val klsInstance: Command,
    private val method: KFunction<*>
) : Executable {

    override fun isSubCommand() = true
    override fun properties() = properties

    override fun execute(ctx: Context) {
        if (method.isSuspend) { // Async
            GlobalScope.async {
                try {
                    method.callSuspend(klsInstance, ctx)
                } catch (e: Throwable) {
                    BoobBot.log.error("Error in subcommand ${method.name}", e)
                    ctx.message.addReaction("\uD83D\uDEAB").queue()
                }
            }
        } else {
            try {
                method.call(klsInstance, ctx)
            } catch (e: Throwable) {
                BoobBot.log.error("Error in subcommand ${method.name}", e)
                ctx.message.addReaction("\uD83D\uDEAB").queue()
            }
        }
    }

}