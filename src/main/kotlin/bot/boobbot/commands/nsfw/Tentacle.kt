package bot.boobbot.commands.nsfw

import bot.boobbot.flight.api.Category
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.models.BbApiCommand

@CommandProperties(
    description = "tentacles.",
    nsfw = true,
    category = Category.KINKS,
    aliases = ["aly"]
)
class Tentacle : BbApiCommand("tentacle")
