package bot.boobbot.models

import bot.boobbot.BoobBot
import bot.boobbot.flight.api.Command
import bot.boobbot.flight.api.Context
import net.dv8tion.jda.api.Permission
import okhttp3.Headers
import okhttp3.HttpUrl

abstract class MemeAvatarCommand(private val category: String) : Command() {

    private val endpointUrl = "https://dankmemer.services/api/$category"
    private val urlBuilder
        get() = HttpUrl.parse(endpointUrl)!!.newBuilder()

    private val headers = Headers.of("Authorization", BoobBot.config.memerImgenKey)

    override suspend fun executeAsync(ctx: Context) {
        if (!ctx.botCan(Permission.MESSAGE_WRITE)) {
            return
        }

        if (!ctx.botCan(Permission.MESSAGE_ATTACH_FILES)) {
            return ctx.send("I can't send images here, fix it whore.")
        }

        val user = ctx.mentions.firstOrNull() ?: ctx.author
        val url = urlBuilder.addQueryParameter("avatar1", user.effectiveAvatarUrl).build()

        val res = BoobBot.requestUtil.get(url.toString(), headers).await()?.body()
            ?: return ctx.send("rip some error press f")

        ctx.channel.sendFile(res.byteStream(), "$category.png").queue()
    }

}
