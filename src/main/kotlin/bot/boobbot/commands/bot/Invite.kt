package bot.boobbot.commands.bot

import bot.boobbot.BoobBot
import bot.boobbot.flight.api.Command
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.flight.api.Context
import bot.boobbot.misc.Colors
import bot.boobbot.misc.Formats
import java.time.Instant

@CommandProperties(description = "Bot and support guild links", aliases = ["join", "oauth", "link", "links", "support"])
class Invite : Command() {

    override fun execute(ctx: Context) {
        val requester = BoobBot.shardManager.authorOrAnonymous(ctx)

        ctx.embed {
            setColor(Colors.rndColor)
            setAuthor(ctx.selfUser.name, ctx.selfUser.effectiveAvatarUrl, ctx.selfUser.effectiveAvatarUrl)
            setDescription(Formats.LING_MSG)
            setFooter("Requested by ${requester.name}", requester.effectiveAvatarUrl)
            setTimestamp(Instant.now())
        }
    }

}