package com.henriquebarucco.urben.infrastructure.database.mongodb.repositories

import com.henriquebarucco.urben.infrastructure.database.mongodb.documents.PercentageMongoDocument
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface PercentageMongoRepository : MongoRepository<PercentageMongoDocument, Int> {
    @Query("{ id: 1 }")
    fun findFirst(): Optional<PercentageMongoDocument>
}
