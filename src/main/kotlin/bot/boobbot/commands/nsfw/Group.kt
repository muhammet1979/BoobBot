package bot.boobbot.commands.nsfw

import bot.boobbot.flight.api.Category
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.models.BbApiCommand

@CommandProperties(description = "For when 2 aren't enough...", nsfw = true, category = Category.KINKS)
class Group : BbApiCommand("group")
