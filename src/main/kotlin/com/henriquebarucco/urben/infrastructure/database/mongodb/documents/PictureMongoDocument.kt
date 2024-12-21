package com.henriquebarucco.urben.infrastructure.database.mongodb.documents

import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document(collection = "pictures")
data class PictureMongoDocument(
    val id: Int,
    val name: String,
    val url: String,
    val createdAt: Instant,
    val sentAt: Instant?,
)
