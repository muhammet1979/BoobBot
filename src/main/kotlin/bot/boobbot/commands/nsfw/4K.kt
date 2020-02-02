package bot.boobbot.commands.nsfw

import bot.boobbot.flight.api.Category
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.models.BbApiCommand

@CommandProperties(
    description = "4K Hotness! <:p_:475801484282429450> ",
    nsfw = true,
    category = Category.GENERAL,
    donorOnly = true
)
class `4K` : BbApiCommand("4k")
