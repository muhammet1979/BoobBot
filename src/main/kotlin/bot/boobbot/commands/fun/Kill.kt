package bot.boobbot.commands.`fun`

import bot.boobbot.flight.api.Category
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.models.FunCommand

@CommandProperties(description = "Kill someone.", category = Category.FUN)
class Kill : FunCommand("kills")
