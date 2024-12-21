package com.henriquebarucco.urben.domain.picture

interface PictureRepository {
    fun create(picture: Picture)

    fun update(picture: Picture)

    fun findAll(): List<Picture>
}
