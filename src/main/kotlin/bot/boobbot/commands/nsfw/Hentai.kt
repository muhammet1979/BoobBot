package bot.boobbot.commands.nsfw

import bot.boobbot.flight.api.Category
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.models.BbApiCommand

@CommandProperties(description = "Hentai.", nsfw = true, category = Category.FANTASY)
class Hentai : BbApiCommand("hentai")
