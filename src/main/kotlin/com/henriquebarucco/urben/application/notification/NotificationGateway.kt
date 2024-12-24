package com.henriquebarucco.urben.application.notification

interface NotificationGateway {
    fun send(message: String)

    fun send(
        photo: ByteArray,
        url: String,
        name: String,
    )
}
