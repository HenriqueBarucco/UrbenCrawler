package com.henriquebarucco.urben.infrastructure.external.discord

import com.henriquebarucco.urben.application.notification.NotificationGateway
import dev.kord.common.Color
import dev.kord.common.entity.Snowflake
import dev.kord.core.Kord
import dev.kord.rest.builder.message.embed
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class DiscordNotificationGateway(
    @Value("\${discord.token}")
    private val token: String,
    @Value("\${discord.channelId}")
    private val channelId: String,
) : NotificationGateway {
    private lateinit var kord: Kord

    init {
        GlobalScope.launch {
            kord = Kord(token)
            kord.login()
        }
    }

    override fun send(message: String) {
        runBlocking {
            val channelService = kord.rest.channel
            channelService.createMessage(Snowflake(channelId)) {
                content = message
            }
        }
    }

    override fun send(
        photo: ByteArray,
        url: String,
        name: String,
    ) {
        runBlocking {
            val channelService = kord.rest.channel
            channelService.createMessage(Snowflake(channelId)) {
                embed {
                    description = name
                    color = Color(0x00FF00)
                    image = url
                }
            }
        }
    }
}
