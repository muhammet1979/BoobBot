package bot.boobbot.commands.audio

import bot.boobbot.BoobBot.Companion.playerManager
import bot.boobbot.audio.AudioLoader
import bot.boobbot.flight.CommandProperties
import bot.boobbot.flight.Context
import bot.boobbot.models.VoiceCommand
import net.dv8tion.jda.core.Permission
import java.util.concurrent.TimeUnit

@CommandProperties(description = "Plays a PornHub, RedTube link from the given URL", category = CommandProperties.category.AUDIO,guildOnly = true, nsfw = true)
class Play : VoiceCommand {

    override fun execute(ctx: Context) {
        val shouldPlay = performVoiceChecks(ctx)

        if (!shouldPlay) {
            return
        }

        if (ctx.args.isEmpty() || ctx.args[0].isEmpty()) {
            return ctx.send("Gotta specify a link, whore")
        }

        val player = ctx.audioPlayer!!
        val query = ctx.args[0].replace("<","").replace(">", "")

        playerManager.loadItem(query, AudioLoader(player, ctx))
       // if (ctx.botCan(Permission.MESSAGE_MANAGE)) {
            //ctx.message.delete().reason("no spam").queueAfter(5, TimeUnit.SECONDS)
        //}
    }

}
