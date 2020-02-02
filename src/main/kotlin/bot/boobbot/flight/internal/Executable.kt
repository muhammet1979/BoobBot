package bot.boobbot.flight.internal

import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.flight.api.Context

interface Executable {
    /**
     * duh
     */
    fun execute(ctx: Context)

    /**
     * Performs command-local checks to determine whether execution should proceed with
     * the given context.
     *
     * @return Whether the execution should proceed.
     */
    fun doLocalCheck(ctx: Context): Boolean = true

    fun isSubCommand(): Boolean = false
    fun properties(): CommandProperties
    fun name(): String = this.javaClass.simpleName.toLowerCase()
}
