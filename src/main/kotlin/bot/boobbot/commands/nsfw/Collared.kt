package bot.boobbot.commands.nsfw

import bot.boobbot.flight.api.Category
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.models.BbApiCommand

@CommandProperties(description = "Play nice.", nsfw = true, category = Category.KINKS)
class Collared : BbApiCommand("collared")
