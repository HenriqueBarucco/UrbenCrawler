package com.henriquebarucco.urben.infrastructure.external.http.easywhatsapp

import com.henriquebarucco.urben.infrastructure.external.http.easywhatsapp.models.SendTextMessageRequest
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(
    name = "easywhatsapp",
    url = "\${easywhatsapp.url}",
)
interface EasyWhatsAppClient {
    @PostMapping("\${easywhatsapp.endpoints.text-message}")
    fun sendMessage(
        @RequestBody request: SendTextMessageRequest,
    ): ResponseEntity<*>
}
