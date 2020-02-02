package bot.boobbot.commands.`fun`

import bot.boobbot.flight.api.Category
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.models.FunCommand

@CommandProperties(description = "fun interactions.", category = Category.FUN, aliases = ["int"])
class Interact : FunCommand("interaction")
