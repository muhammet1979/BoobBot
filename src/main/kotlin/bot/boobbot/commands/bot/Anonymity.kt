package bot.boobbot.commands.bot

import bot.boobbot.BoobBot
import bot.boobbot.flight.api.Command
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.flight.api.Context
import bot.boobbot.flight.api.SubCommand

@CommandProperties(
    description = "Change whether you're shown on embeds",
    donorOnly = true,
    aliases = ["cb"]
)
class Anonymity : Command() {

    override fun execute(ctx: Context) {
        ctx.send("`bbanonymity <${subcommands.keys.joinToString("|")}>`")
    }

    @CommandProperties(description = "Hides you from command response embeds.")
    fun on(ctx: Context) {
        BoobBot.database.setUserAnonymity(ctx.author.id, true)
        ctx.send("You're now anonymous \uD83D\uDD75")
    }

    @CommandProperties(description = "Shows you on command response embeds.")
    fun off(ctx: Context) {
        BoobBot.database.setUserAnonymity(ctx.author.id, false)
        ctx.send("You're no longer anonymous 👀")
    }

}
