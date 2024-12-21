package com.henriquebarucco.urben.infrastructure.scheduler

import com.henriquebarucco.urben.application.urben.VerifyUrbenNewPicturesUseCase
import com.henriquebarucco.urben.application.urben.VerifyUrbenStatusUseCase
import com.henriquebarucco.urben.domain.token.GenerateAccessTokenGateway
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class UrbenCrawlerScheduler(
    private val verifyUrbenStatusUseCase: VerifyUrbenStatusUseCase,
    private val generateAccessTokenGateway: GenerateAccessTokenGateway,
    private val verifyUrbenNewPicturesUseCase: VerifyUrbenNewPicturesUseCase,
) {
    @Scheduled(cron = "\${scheduler.cron}")
    fun execute() {
        val token = this.generateAccessTokenGateway.generate()

        this.verifyUrbenStatusUseCase.execute(token)
        this.verifyUrbenNewPicturesUseCase.execute(token)
    }
}
