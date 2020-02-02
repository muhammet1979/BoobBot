package bot.boobbot.commands.meme

import bot.boobbot.flight.api.Category
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.models.MemeAvatarCommand

@CommandProperties(description = "sick.", category = Category.MEME, guildOnly = true)
class Sick : MemeAvatarCommand("sickban")