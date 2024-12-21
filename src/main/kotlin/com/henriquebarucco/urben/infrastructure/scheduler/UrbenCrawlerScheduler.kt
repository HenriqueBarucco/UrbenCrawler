package com.henriquebarucco.urben.infrastructure.scheduler

import com.henriquebarucco.urben.application.urben.VerifyUrbenNewPicturesUseCase
import com.henriquebarucco.urben.application.urben.VerifyUrbenStatusUseCase
import com.henriquebarucco.urben.domain.token.GenerateAccessTokenGateway
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class UrbenCrawlerScheduler(
    private val verifyUrbenStatusUseCase: VerifyUrbenStatusUseCase,
    private val generateAccessTokenGateway: GenerateAccessTokenGateway,
    private val verifyUrbenNewPicturesUseCase: VerifyUrbenNewPicturesUseCase,
) {
    private val log = LoggerFactory.getLogger(UrbenCrawlerScheduler::class.java)

    @Scheduled(cron = "\${scheduler.cron}")
    fun execute() {
        log.info("Starting Urben Crawler")

        val token = this.generateAccessTokenGateway.generate()

        this.verifyUrbenStatusUseCase.execute(token)
        this.verifyUrbenNewPicturesUseCase.execute(token)

        log.info("Urben Crawler finished")
    }
}
