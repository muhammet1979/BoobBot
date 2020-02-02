package bot.boobbot.commands.bot

import bot.boobbot.BoobBot
import bot.boobbot.flight.api.Command
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.flight.api.Context
import bot.boobbot.misc.Formats
import bot.boobbot.misc.Utils
import net.dv8tion.jda.api.Permission

@CommandProperties(aliases = ["cc"], description = "Manage custom commands.", guildOnly = true)
class Custom : Command() {

    override fun execute(ctx: Context) {
        ctx.send("`bbcc <${subcommands.keys.joinToString("|")}>`")
    }

    @CommandProperties(description = "Adds a custom command for this server.")
    fun add(ctx: Context) {
        if (!ctx.userCan(Permission.MANAGE_SERVER)) {
            ctx.send("You don't have `MANAGE_SERVER` permission, whore.")
            return
        }

        if (!Utils.checkDonor(ctx.message)) {
            ctx.channel.sendMessage(
                Formats.error(
                    " Sorry this command is only available to our Patrons.\n<:p_:475801484282429450> "
                            + "Stop being a cheap fuck and join today!\nhttps://www.patreon.com/OfficialBoobBot"
                )
            ).queue()
            return
        }

        if (ctx.args.isEmpty() || ctx.args.size < 2) {
            return ctx.send("You need to specify tag name and content, whore.")
        }

        val tagName = ctx.args[0]
        val tagContent = ctx.args.drop(1).joinToString(" ")

        BoobBot.database.addCustomCommand(ctx.guild!!.id, tagName, tagContent)
        ctx.send("done whore")
    }

    @CommandProperties(aliases = ["del", "remove", "rem"], description = "Removes a custom command for this server.")
    fun delete(ctx: Context) {
        if (!ctx.userCan(Permission.MANAGE_SERVER)) {
            ctx.send("You don't have `MANAGE_SERVER` permission, whore.")
            return
        }

        val tagName = ctx.args.firstOrNull()
            ?: return ctx.send("what tag do you want to delete, whore")

        if (BoobBot.database.findCustomCommand(ctx.guild!!.id, tagName) == null) {
            return ctx.send("wtf, why are you trying to remove a non-existent command?")
        }

        BoobBot.database.removeCustomCommand(ctx.guild.id, tagName)
        ctx.send("done whore")
    }

    @CommandProperties(description = "Lists all custom commands for this server.")
    fun list(ctx: Context) {
        val allCommands = BoobBot.database.getCustomCommands(ctx.guild!!.id)

        if (allCommands.isEmpty()) {
            return ctx.send("This server has no custom commands.")
        }

        ctx.send("```\n${allCommands.keys.joinToString(", ")}```")
    }

}