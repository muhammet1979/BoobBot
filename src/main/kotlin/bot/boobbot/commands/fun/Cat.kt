package bot.boobbot.commands.`fun`

import bot.boobbot.flight.api.Category
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.models.NekoLifeApiCommand

@CommandProperties(description = "random cat", category = Category.FUN, aliases = ["meow"])
class Cat : NekoLifeApiCommand("meow")
