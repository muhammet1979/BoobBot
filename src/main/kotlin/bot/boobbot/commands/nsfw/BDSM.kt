package bot.boobbot.commands.nsfw

import bot.boobbot.flight.api.Category
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.models.BbApiCommand

@CommandProperties(
    description = "Bondage and Discipline (BD), Dominance and Submission (DS), Sadism and Masochism (SM)",
    nsfw = true,
    category = Category.KINKS
)
class BDSM : BbApiCommand("bdsm")
