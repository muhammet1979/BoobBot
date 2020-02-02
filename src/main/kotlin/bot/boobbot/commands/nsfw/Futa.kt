package bot.boobbot.commands.nsfw

import bot.boobbot.flight.api.Category
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.models.BbApiCommand

@CommandProperties(description = "Hentai Traps.", nsfw = true, category = Category.FANTASY)
class Futa : BbApiCommand("futa")
