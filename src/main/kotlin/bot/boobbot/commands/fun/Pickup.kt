package bot.boobbot.commands.`fun`

import bot.boobbot.flight.api.Category
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.models.FunCommand

@CommandProperties(description = "Pickup someone.", category = Category.FUN, aliases = ["pu"])
class Pickup : FunCommand("pickups")
