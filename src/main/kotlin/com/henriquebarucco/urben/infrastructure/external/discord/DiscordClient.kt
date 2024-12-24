package com.henriquebarucco.urben.infrastructure.external.discord

import dev.kord.core.Kord
import dev.kord.core.behavior.interaction.response.respond
import dev.kord.core.event.interaction.GlobalChatInputCommandInteractionCreateEvent
import dev.kord.core.on
import dev.kord.rest.service.ChannelService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

abstract class DiscordClient(
    private val token: String,
) {
    private lateinit var kord: Kord

    val channelService: ChannelService
        get() = kord.rest.channel

    init {
        GlobalScope.launch {
            kord = Kord(token)

            registerPongCommand()

            kord.login()
        }
    }

    private suspend fun registerPongCommand() {
        kord.createGlobalChatInputCommand(
            "pong",
            "A simple Pong command",
        )

        kord.on<GlobalChatInputCommandInteractionCreateEvent> {
            if (interaction.command.rootName == "pong") {
                val response = interaction.deferPublicResponse()
                response.respond {
                    content = "Pong!"
                }
            }
        }
    }
}
