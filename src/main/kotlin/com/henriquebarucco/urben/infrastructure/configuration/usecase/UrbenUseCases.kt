package com.henriquebarucco.urben.infrastructure.configuration.usecase

import com.henriquebarucco.urben.application.notification.NotificationGateway
import com.henriquebarucco.urben.application.urben.DefaultVerifyUrbenNewPicturesUseCase
import com.henriquebarucco.urben.application.urben.DefaultVerifyUrbenStatusUseCase
import com.henriquebarucco.urben.application.urben.VerifyUrbenNewPicturesUseCase
import com.henriquebarucco.urben.application.urben.VerifyUrbenStatusUseCase
import com.henriquebarucco.urben.domain.percentage.PercentageRepository
import com.henriquebarucco.urben.domain.percentage.gateway.CurrentPercentageGateway
import com.henriquebarucco.urben.domain.picture.PictureRepository
import com.henriquebarucco.urben.domain.picture.gateway.PicturesGateway
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UrbenUseCases(
    private val currentPercentageGateway: CurrentPercentageGateway,
    private val percentageRepository: PercentageRepository,
    private val notificationGateway: NotificationGateway,
    private val picturesGateway: PicturesGateway,
    private val pictureRepository: PictureRepository,
) {
    @Bean
    fun verifyUrbenStatusUseCase(): VerifyUrbenStatusUseCase =
        DefaultVerifyUrbenStatusUseCase(
            currentPercentageGateway = currentPercentageGateway,
            percentageRepository = percentageRepository,
            notificationGateway = notificationGateway,
        )

    @Bean
    fun verifyUrbenNewPicturesUseCase(): VerifyUrbenNewPicturesUseCase =
        DefaultVerifyUrbenNewPicturesUseCase(
            picturesGateway = picturesGateway,
            pictureRepository = pictureRepository,
            notificationGateway = notificationGateway,
        )
}
