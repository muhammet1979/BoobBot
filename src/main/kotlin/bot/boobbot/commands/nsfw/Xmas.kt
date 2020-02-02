package bot.boobbot.commands.nsfw

import bot.boobbot.flight.api.Category
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.models.BbApiCommand

@CommandProperties(description = "Christmas \uD83C\uDF85", nsfw = true, category = Category.HOLIDAY)
class Xmas : BbApiCommand("xmas")
