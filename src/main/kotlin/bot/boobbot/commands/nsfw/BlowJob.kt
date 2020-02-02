package bot.boobbot.commands.nsfw

import bot.boobbot.flight.api.Category
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.models.BbApiCommand

@CommandProperties(description = "BlowJobs!", nsfw = true, aliases = ["bj"], category = Category.GENERAL)
class BlowJob : BbApiCommand("blowjob")
