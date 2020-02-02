package bot.boobbot.commands.nsfw

import bot.boobbot.flight.api.Category
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.models.BbApiCommand

@CommandProperties(description = "Valentines ❤", nsfw = true, category = Category.HOLIDAY)
class VDay : BbApiCommand("vday")
