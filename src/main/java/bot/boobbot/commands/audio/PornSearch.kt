package bot.boobbot.commands.audio

import bot.boobbot.BoobBot.Companion.playerManager
import bot.boobbot.audio.AudioLoader
import bot.boobbot.flight.CommandProperties
import bot.boobbot.flight.Context
import bot.boobbot.models.VoiceCommand
import net.dv8tion.jda.core.Permission
import java.util.concurrent.TimeUnit

@CommandProperties(description = "Searches PornHub for videos to play", category = CommandProperties.category.AUDIO,guildOnly = true, nsfw = true)
class PornSearch : VoiceCommand {

    override fun execute(ctx: Context) {
        val shouldPlay = performVoiceChecks(ctx)

        if (!shouldPlay) {
            return
        }

        if (ctx.args.isEmpty() || ctx.args[0].isEmpty()) {
            return ctx.send("Gotta specify a search query, whore")
        }

        val player = ctx.audioPlayer!!
        val query = "phsearch:${ctx.args.joinToString(" ")}"

        playerManager.loadItem(query, AudioLoader(player, ctx))
        //if (ctx.botCan(Permission.MESSAGE_MANAGE)) {
            //ctx.message.delete().reason("no spam").queueAfter(5, TimeUnit.SECONDS)
        //}
    }
}