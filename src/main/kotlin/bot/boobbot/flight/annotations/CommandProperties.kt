package bot.boobbot.flight.annotations

import bot.boobbot.flight.api.Category

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class CommandProperties(
    val aliases: Array<String> = [],
    val description: String = "No description available",
    /** NOT APPLICABLE TO SUBCOMMANDS */
    val category: Category = Category.MISC,
    /** ----------------------------- */
    val developerOnly: Boolean = false,
    val donorOnly: Boolean = false,
    val nsfw: Boolean = false,
    val guildOnly: Boolean = false,
    val hidden: Boolean = false
)

