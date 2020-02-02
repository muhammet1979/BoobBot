package bot.boobbot.commands.nsfw

import bot.boobbot.flight.api.Category
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.models.BbApiCommand

@CommandProperties(description = "Real girls!", nsfw = true, category = Category.GENERAL)
class Real : BbApiCommand("real")
