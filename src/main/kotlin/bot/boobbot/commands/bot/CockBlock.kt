package bot.boobbot.commands.bot

import bot.boobbot.BoobBot
import bot.boobbot.flight.api.Command
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.flight.api.Context

@CommandProperties(
    description = "Change whether you can receive dicks in your DMs",
    donorOnly = true,
    aliases = ["cb"]
)
class CockBlock : Command() {

    override fun execute(ctx: Context) {
        ctx.send("`bbcockblock <${subcommands.keys.joinToString("|")}>`")
    }

    @CommandProperties(description = "Disallows users from running `bbsenddicks` on you.")
    fun on(ctx: Context) {
        BoobBot.database.setUserCockBlocked(ctx.author.id, true)
        ctx.send("You're no longer able to receive dicks via DMs \uD83C\uDF46") // eggplant
    }

    @CommandProperties(description = "Allows users to run `bbsenddicks` on you.")
    fun off(ctx: Context) {
        BoobBot.database.setUserCockBlocked(ctx.author.id, false)
        ctx.send("You're now able to receive dicks via DMs <:moans:583453348984913933>")
    }

}
