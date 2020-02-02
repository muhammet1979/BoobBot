package bot.boobbot.commands.nsfw

import bot.boobbot.flight.api.Category
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.models.BbApiCommand

@CommandProperties(description = "Boy love.", nsfw = true, category = Category.FANTASY)
class Yaoi : BbApiCommand("yaoi")
