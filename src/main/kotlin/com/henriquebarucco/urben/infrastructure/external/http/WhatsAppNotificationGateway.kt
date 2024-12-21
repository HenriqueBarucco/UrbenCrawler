package com.henriquebarucco.urben.infrastructure.external.http

import com.henriquebarucco.urben.application.notification.NotificationGateway
import com.henriquebarucco.urben.infrastructure.external.http.easywhatsapp.EasyWhatsAppClient
import com.henriquebarucco.urben.infrastructure.external.http.easywhatsapp.EasyWhatsAppCustom
import com.henriquebarucco.urben.infrastructure.external.http.easywhatsapp.models.SendTextMessageRequest
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class WhatsAppNotificationGateway(
    private val easyWhatsAppClient: EasyWhatsAppClient,
    @Value("\${easywhatsapp.url}")
    private val url: String,
    @Value("\${easywhatsapp.endpoints.image-message}")
    private val imageEndpoint: String,
    @Value("\${easywhatsapp.token}")
    private val token: String,
    @Value("\${easywhatsapp.phone}")
    private val phone: String,
) : NotificationGateway {
    private val log = LoggerFactory.getLogger(WhatsAppNotificationGateway::class.java)

    override fun send(message: String) {
        val request =
            SendTextMessageRequest(
                token = this.token,
                phone = this.phone,
                message = message,
            )

        this.easyWhatsAppClient.sendMessage(request)

        log.info("Message sent to WhatsApp")
    }

    override fun send(
        photo: ByteArray,
        name: String,
    ) {
        val client = EasyWhatsAppCustom(url, imageEndpoint)

        client.sendPhoto(
            token = this.token,
            phone = this.phone,
            photo = photo,
            name = name,
        )

        log.info("Photo sent to WhatsApp")
    }
}
