package com.henriquebarucco.urben.infrastructure.external.http

import com.henriquebarucco.urben.domain.picture.Picture
import com.henriquebarucco.urben.domain.picture.gateway.PicturesGateway
import com.henriquebarucco.urben.infrastructure.external.http.urben.UrbenClient
import org.springframework.stereotype.Service

@Service
class PicturesUrbenGateway(
    private val urbenClient: UrbenClient,
) : PicturesGateway {
    override fun get(accessToken: String): List<Picture> {
        val response = this.urbenClient.pictures("Bearer $accessToken")

        val body = response.body ?: throw RuntimeException("Failed to get pictures")

        val pictures = mutableListOf<Picture>()

        body.map { midia ->
            midia.midias.map {
                pictures.add(
                    Picture.new(
                        id = it.idMidia,
                        name = it.nome,
                        url = it.url,
                    ),
                )
            }
        }

        return pictures
    }
}
