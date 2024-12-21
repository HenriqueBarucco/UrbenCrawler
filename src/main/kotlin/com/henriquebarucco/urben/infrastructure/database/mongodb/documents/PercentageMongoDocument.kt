package com.henriquebarucco.urben.infrastructure.database.mongodb.documents

import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document(collection = "percentages")
data class PercentageMongoDocument(
    val id: Int,
    val value: Double,
    val updatedAt: Instant?,
)
