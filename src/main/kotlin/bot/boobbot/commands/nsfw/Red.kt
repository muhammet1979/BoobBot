package bot.boobbot.commands.nsfw

import bot.boobbot.flight.api.Category
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.models.BbApiCommand

@CommandProperties(
    description = "Redheads: because redder is better! <:p_:475801484282429450> ",
    aliases = ["redhead", "redheads"],
    nsfw = true,
    category = Category.GENERAL,
    donorOnly = true
)
class Red : BbApiCommand("red")
