package bot.boobbot.flight.api

import bot.boobbot.BoobBot
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.flight.internal.Executable
import bot.boobbot.misc.Colors
import bot.boobbot.misc.Formats
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import net.dv8tion.jda.api.EmbedBuilder
import java.time.Instant

open class Command : Executable {
    val subcommands = hashMapOf<String, SubCommand>()

    override fun properties(): CommandProperties {
        return this::class.java.getAnnotation(CommandProperties::class.java)
    }

    override fun execute(ctx: Context) {
        GlobalScope.async {
            executeAsync(ctx)
        }
    }

    open suspend fun executeAsync(ctx: Context) {

    }

    fun findSubcommand(name: String): SubCommand? {
        return subcommands[name]
            ?: subcommands.values.firstOrNull { it.properties.aliases.contains(name) }
    }

    fun sendSubcommandHelp(ctx: Context) {
        val requester = BoobBot.shardManager.authorOrAnonymous(ctx)
        val embed = EmbedBuilder()
            .setColor(Colors.getEffectiveColor(ctx.message))
            .setAuthor(
                "${ctx.selfUser.name} help ${Formats.MAGIC_EMOTE}",
                "https://boob.bot/commands",
                ctx.selfUser.effectiveAvatarUrl
            )
            .setFooter("Help requested by ${requester.name}", requester.effectiveAvatarUrl)
            .setTimestamp(Instant.now())

        for (sc in this.subcommands.values.sortedBy { it.name }) {
            embed.appendDescription("`${padEnd(sc.name, 16)}:` ${sc.properties.description}\n")
        }

        ctx.embed(embed.build())
    }

    private fun padEnd(str: String, length: Int = 15): String {
        return str + "\u200B ".repeat(length - str.length)
    }
}
