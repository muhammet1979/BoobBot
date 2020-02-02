package bot.boobbot.commands.nsfw

import bot.boobbot.flight.api.Category
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.models.BbApiCommand

@CommandProperties(description = "Got dick?", nsfw = true, category = Category.GENERAL)
class Dick : BbApiCommand("penis")
