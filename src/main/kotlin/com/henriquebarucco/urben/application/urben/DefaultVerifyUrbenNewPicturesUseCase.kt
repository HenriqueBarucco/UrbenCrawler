package com.henriquebarucco.urben.application.urben

import com.henriquebarucco.urben.application.notification.NotificationGateway
import com.henriquebarucco.urben.application.utils.PictureDownloader
import com.henriquebarucco.urben.domain.picture.Picture
import com.henriquebarucco.urben.domain.picture.PictureRepository
import com.henriquebarucco.urben.domain.picture.gateway.PicturesGateway
import java.time.Instant

class DefaultVerifyUrbenNewPicturesUseCase(
    private val picturesGateway: PicturesGateway,
    private val pictureRepository: PictureRepository,
    private val notificationGateway: NotificationGateway,
) : VerifyUrbenNewPicturesUseCase {
    override fun execute(token: String) {
        val pictures = this.picturesGateway.get(token)
        pictures.map { this.pictureRepository.create(it) }

        process()
    }

    private fun process() {
        val pictures = this.pictureRepository.findAll()

        pictures
            .filter { it.sentAt == null }
            .map {
                notify(it)

                it.update(Instant.now())
                this.pictureRepository.update(it)
            }
    }

    private fun notify(picture: Picture) {
        val photo = PictureDownloader.download(picture.url)
        this.notificationGateway.send(photo, picture.name)
    }
}
