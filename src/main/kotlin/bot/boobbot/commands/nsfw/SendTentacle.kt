package bot.boobbot.commands.nsfw

import bot.boobbot.flight.api.Category
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.models.SendCommand

@CommandProperties(
    description = "Sends Tentacles to you or another user",
    guildOnly = true,
    aliases = ["sendaly"],
    category = Category.SEND
)
class SendTentacle : SendCommand("Tentacles", "tentacle")
