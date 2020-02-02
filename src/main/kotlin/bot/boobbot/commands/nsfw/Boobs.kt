package bot.boobbot.commands.nsfw

import bot.boobbot.flight.api.Category
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.models.BbApiCommand

@CommandProperties(description = "Shows some boobs.", nsfw = true, category = Category.GENERAL)
class Boobs : BbApiCommand("boobs")
