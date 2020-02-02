package bot.boobbot.commands.nsfw

import bot.boobbot.flight.api.Category
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.models.NekoLifeApiCommand

@CommandProperties(
    description = "Lewd Neko gifs! <:p_:475801484282429450>",
    nsfw = true,
    category = Category.FANTASY,
    donorOnly = true,
    aliases = ["ng"]
)
class Nekogif : NekoLifeApiCommand("nsfw_neko_gif")
