package bot.boobbot.commands.nsfw

import bot.boobbot.flight.CommandProperties
import bot.boobbot.models.BbApiCommand

@CommandProperties(description = "Shows some boobs.", nsfw = true, category = CommandProperties.category.GENERAL)
class Boobs : BbApiCommand("boobs")
