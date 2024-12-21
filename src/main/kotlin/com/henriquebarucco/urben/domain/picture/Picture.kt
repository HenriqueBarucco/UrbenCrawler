package com.henriquebarucco.urben.domain.picture

import java.time.Instant

data class Picture(
    val id: Int,
    val name: String,
    val url: String,
    val createdAt: Instant,
    var sentAt: Instant?,
) {
    companion object {
        fun new(
            id: Int,
            name: String,
            url: String,
        ): Picture =
            Picture(
                id = id,
                name = name,
                url = url,
                createdAt = Instant.now(),
                sentAt = null,
            )

        fun with(
            id: Int,
            name: String,
            url: String,
            createdAt: Instant,
            sentAt: Instant?,
        ): Picture =
            Picture(
                id = id,
                name = name,
                url = url,
                createdAt = createdAt,
                sentAt = sentAt,
            )
    }

    fun update(sentAt: Instant): Picture {
        this.sentAt = sentAt

        return this
    }
}
