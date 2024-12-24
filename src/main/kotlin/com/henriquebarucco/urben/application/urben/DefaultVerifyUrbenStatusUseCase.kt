package com.henriquebarucco.urben.application.urben

import com.henriquebarucco.urben.application.constanst.PERCENTAGE_CHANGED
import com.henriquebarucco.urben.application.notification.NotificationGateway
import com.henriquebarucco.urben.domain.percentage.Percentage
import com.henriquebarucco.urben.domain.percentage.PercentageRepository
import com.henriquebarucco.urben.domain.percentage.gateway.CurrentPercentageGateway

class DefaultVerifyUrbenStatusUseCase(
    private val currentPercentageGateway: CurrentPercentageGateway,
    private val percentageRepository: PercentageRepository,
    private val notificationGateway: List<NotificationGateway>,
) : VerifyUrbenStatusUseCase {
    override fun execute(token: String) {
        val percentage = this.percentageRepository.get()
        val currentPercentage = this.currentPercentageGateway.get(token)

        if (percentage.value == currentPercentage) return

        notify(currentPercentage)
        updatePercentage(percentage, currentPercentage)
    }

    private fun updatePercentage(
        percentage: Percentage,
        currentPercentage: Double,
    ) {
        percentage.update(currentPercentage)
        this.percentageRepository.save(percentage)
    }

    private fun notify(currentPercentage: Double) {
        this.notificationGateway.map { it.send(String.format(PERCENTAGE_CHANGED, currentPercentage)) }
    }
}
