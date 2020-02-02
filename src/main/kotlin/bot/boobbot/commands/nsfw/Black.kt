package bot.boobbot.commands.nsfw

import bot.boobbot.flight.api.Category
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.models.BbApiCommand

@CommandProperties(description = "Gotta have that black love as well.", nsfw = true, category = Category.GENERAL)
class Black : BbApiCommand("black")
