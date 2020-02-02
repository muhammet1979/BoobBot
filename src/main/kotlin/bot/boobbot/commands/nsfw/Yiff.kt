package bot.boobbot.commands.nsfw

import bot.boobbot.flight.api.Category
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.models.BbApiCommand

@CommandProperties(description = "Fucking furries", nsfw = true, category = Category.FANTASY)
class Yiff : BbApiCommand("yiff")
