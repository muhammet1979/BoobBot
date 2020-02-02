package bot.boobbot.commands.`fun`

import bot.boobbot.BoobBot
import bot.boobbot.flight.api.Category
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.flight.api.Command
import bot.boobbot.flight.api.Context
import bot.boobbot.misc.json

@CommandProperties(description = "Random why questions", category = Category.FUN)
class Why : Command() {

    override suspend fun executeAsync(ctx: Context) {

        val res = BoobBot.requestUtil
            .get("https://nekos.life/api/v2/why")
            .await()
            ?: return ctx.send("rip some error, press f")
        val body = res.json() ?: return ctx.send("rip some error, press f")
        ctx.send(body.get("why").toString())
    }

}