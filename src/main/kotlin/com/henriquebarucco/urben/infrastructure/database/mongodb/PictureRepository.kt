package com.henriquebarucco.urben.infrastructure.database.mongodb

import com.henriquebarucco.urben.domain.picture.Picture
import com.henriquebarucco.urben.domain.picture.PictureRepository
import com.henriquebarucco.urben.infrastructure.database.mongodb.documents.PictureMongoDocument
import com.henriquebarucco.urben.infrastructure.database.mongodb.repositories.PictureMongoRepository
import org.springframework.stereotype.Service

@Service
class PictureRepository(
    private val pictureMongoRepository: PictureMongoRepository,
) : PictureRepository {
    override fun create(picture: Picture) {
        if (this.pictureMongoRepository.existsById(picture.id)) return

        save(picture)
    }

    override fun update(picture: Picture) {
        save(picture)
    }

    override fun findAll(): List<Picture> {
        val pictureDocuments = this.pictureMongoRepository.findAll()

        return pictureDocuments.map {
            Picture.with(
                id = it.id,
                name = it.name,
                url = it.url,
                createdAt = it.createdAt,
                sentAt = it.sentAt,
            )
        }
    }

    private fun save(picture: Picture) {
        val pictureDocument =
            PictureMongoDocument(
                id = picture.id,
                name = picture.name,
                url = picture.url,
                createdAt = picture.createdAt,
                sentAt = picture.sentAt,
            )

        this.pictureMongoRepository.save(pictureDocument)
    }
}
