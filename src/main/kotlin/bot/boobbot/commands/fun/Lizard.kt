package bot.boobbot.commands.`fun`

import bot.boobbot.flight.api.Category
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.models.NekoLifeApiCommand

@CommandProperties(description = "random Lizard", category = Category.FUN)
class Lizard : NekoLifeApiCommand("lizard")
