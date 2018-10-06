package bot.boobbot.models

import bot.boobbot.flight.Command
import bot.boobbot.flight.Context
import net.dv8tion.jda.core.Permission
import net.dv8tion.jda.core.entities.VoiceChannel

interface VoiceCommand : Command {

    open fun performVoiceChecks(ctx: Context): Boolean {
        if (ctx.guild == null) {
            return false
        }

        if (ctx.voiceState!!.channel == null) {
            ctx.send("Join a voicechannel, whore")
            return false
        }

        if (ctx.audioManager!!.connectedChannel == null) {
            val error = checkVoiceChannelPermissions(ctx.voiceState.channel)

            return if (error == null) {
                ctx.audioManager.openAudioConnection(ctx.voiceState.channel)
                true
            } else {
                ctx.send(error)
                false
            }
        }

        if (ctx.voiceState.channel.idLong != ctx.audioManager.connectedChannel.idLong) {
            ctx.send("You gotta be in my voicechannel, whore.")
            return false
        }

        return true
    }

    open fun checkVoiceChannelPermissions(channel: VoiceChannel): String? {
        val self = channel.guild.selfMember

        if (channel.userLimit != 0 && channel.members.size >= channel.userLimit &&
                !self.hasPermission(channel, Permission.VOICE_MOVE_OTHERS)) {
            return "There's no room in your voicechannel, raise the user limit"
        }

        if (!self.hasPermission(channel, Permission.VOICE_CONNECT)) {
            return "I can't connect to your voicechannel"
        }

        if (!self.hasPermission(channel, Permission.VOICE_SPEAK)) {
            return "I can't play music if I can't speak in your voicechannel"
        }

        return null
    }

}