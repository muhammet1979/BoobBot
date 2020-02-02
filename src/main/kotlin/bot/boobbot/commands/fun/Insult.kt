package bot.boobbot.commands.`fun`

import bot.boobbot.flight.api.Category
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.models.FunCommand

@CommandProperties(description = "Insult someone.", category = Category.FUN, aliases = ["ins"])
class Insult : FunCommand("insult")
