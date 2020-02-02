package bot.boobbot.commands.nsfw

import bot.boobbot.flight.api.Category
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.models.NekoLifeApiCommand

@CommandProperties(description = "Lewd Nekos!", nsfw = true, category = Category.FANTASY)
class Neko : NekoLifeApiCommand("lewd")
