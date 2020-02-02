package bot.boobbot.commands.bot

import bot.boobbot.BoobBot
import bot.boobbot.flight.api.Command
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.flight.api.Context

@CommandProperties(description = "Manage whether you can receive nudes or not")
class Opt : Command() {

    override fun execute(ctx: Context) {
        ctx.send("`bbopt <${subcommands.keys.joinToString("|")}>`")
    }

    @CommandProperties(description = "Allows users to run any `bbsend` commands on you.")
    fun `in`(ctx: Context) {
        BoobBot.database.setUserCanReceiveNudes(ctx.author.id, true)
        ctx.send("You're now able to receive nudes <:moans:583453348984913933>")
    }

    @CommandProperties(description = "Disallows users from running any `bbsend` commands on you.")
    fun out(ctx: Context) {
        BoobBot.database.setUserCanReceiveNudes(ctx.author.id, false)
        ctx.send("You can no longer receive nudes. Whore.")
    }

    @CommandProperties(description = "Check whether you're currently able to receive nudes.")
    fun status(ctx: Context) {
        val current = BoobBot.database.getCanUserReceiveNudes(ctx.author.id)
        val s = if (current) "can" else "can't"
        ctx.send("You $s receive nudes.")
    }

}