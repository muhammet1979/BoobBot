package bot.boobbot.commands.nsfw

import bot.boobbot.flight.api.Category
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.models.BbApiCommand

@CommandProperties(
    description = "Phat Ass White Girls! <:p_:475801484282429450>",
    nsfw = true,
    category = Category.KINKS,
    donorOnly = true
)
class PAWG : BbApiCommand("pawg")
