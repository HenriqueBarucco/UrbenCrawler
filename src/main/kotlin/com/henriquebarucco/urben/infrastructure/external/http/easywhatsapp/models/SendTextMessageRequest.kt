package com.henriquebarucco.urben.infrastructure.external.http.easywhatsapp.models

data class SendTextMessageRequest(
    val token: String,
    val phone: String,
    val message: String,
)
