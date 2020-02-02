package bot.boobbot.commands.nsfw

import bot.boobbot.flight.api.Category
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.models.BbApiCommand

@CommandProperties(
    description = "Sticky Love! <:stickylove:440557161538650113>",
    nsfw = true,
    category = Category.GENERAL
)
class CumSluts : BbApiCommand("cumsluts")
