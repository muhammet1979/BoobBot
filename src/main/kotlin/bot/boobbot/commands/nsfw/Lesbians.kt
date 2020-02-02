package bot.boobbot.commands.nsfw

import bot.boobbot.flight.api.Category
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.models.BbApiCommand

@CommandProperties(description = "Lesbians are sexy!", nsfw = true, category = Category.KINKS)
class Lesbians : BbApiCommand("lesbians")
