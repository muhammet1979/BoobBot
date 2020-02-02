package bot.boobbot.commands.nsfw

import bot.boobbot.flight.api.Category
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.models.BbApiCommand

@CommandProperties(description = "Random thighs", nsfw = true, category = Category.KINKS)
class Thigh : BbApiCommand("ThighBot")
