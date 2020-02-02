package bot.boobbot.commands.nsfw

import bot.boobbot.flight.api.Category
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.models.BbApiCommand

@CommandProperties(description = "Gotta get that double love!", nsfw = true, category = Category.GENERAL)
class DP : BbApiCommand("dpgirls")
