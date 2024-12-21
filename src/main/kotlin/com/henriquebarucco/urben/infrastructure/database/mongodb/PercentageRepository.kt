package com.henriquebarucco.urben.infrastructure.database.mongodb

import com.henriquebarucco.urben.domain.percentage.Percentage
import com.henriquebarucco.urben.domain.percentage.PercentageRepository
import com.henriquebarucco.urben.infrastructure.database.mongodb.documents.PercentageMongoDocument
import com.henriquebarucco.urben.infrastructure.database.mongodb.repositories.PercentageMongoRepository
import org.springframework.stereotype.Service

@Service
class PercentageRepository(
    private val percentageMongoRepository: PercentageMongoRepository,
) : PercentageRepository {
    override fun save(percentage: Percentage) {
        val percentageDocument =
            PercentageMongoDocument(
                id = 1,
                value = percentage.value,
                updatedAt = percentage.updatedAt,
            )

        this.percentageMongoRepository.save(percentageDocument)
    }

    override fun get(): Percentage {
        val percentageDocument = percentageMongoRepository.findFirst()

        return percentageDocument
            .map { percentage ->
                Percentage.with(
                    value = percentage.value,
                    updatedAt = percentage.updatedAt,
                )
            }.orElseGet {
                val newPercentage = Percentage.new()
                save(newPercentage)
                newPercentage
            }
    }
}
