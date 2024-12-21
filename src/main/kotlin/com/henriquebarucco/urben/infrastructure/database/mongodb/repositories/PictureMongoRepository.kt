package com.henriquebarucco.urben.infrastructure.database.mongodb.repositories

import com.henriquebarucco.urben.infrastructure.database.mongodb.documents.PictureMongoDocument
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface PictureMongoRepository : MongoRepository<PictureMongoDocument, Int>
