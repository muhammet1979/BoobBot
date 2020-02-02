package bot.boobbot.commands.bot

import bot.boobbot.BoobBot
import bot.boobbot.flight.annotations.CommandProperties
import bot.boobbot.flight.api.Category
import bot.boobbot.flight.api.Command
import bot.boobbot.flight.api.Context

@CommandProperties(description = "Pong!", category = Category.MISC)
class Ping : Command() {
    override fun execute(ctx: Context) {
        ctx.send("What do you want me to say, pong? No you can go fuck yourself~")
    }

    @CommandProperties(description = "no slut")
    fun please(ctx: Context) {
        val shards = BoobBot.shardManager.shardsTotal
        val shardsOnline = BoobBot.shardManager.onlineShards.size
        val averageShardLatency = BoobBot.shardManager.averageGatewayPing
        ctx.send("**Shard info**: $shardsOnline/$shards\n**Average latency**: ${averageShardLatency}ms")
    }

}