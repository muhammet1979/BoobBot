package bot.boobbot.commands.nsfw

import bot.boobbot.flight.api.Category
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.models.BbApiCommand

@CommandProperties(
    description = "PornHub gifs! (Some are trash #BlamePornHub)",
    nsfw = true,
    category = Category.VIDEOSEARCHING
)
class PHGif : BbApiCommand("pGifs")
