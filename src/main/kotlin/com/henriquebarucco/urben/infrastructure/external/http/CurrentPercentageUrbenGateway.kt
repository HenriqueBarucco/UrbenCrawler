package com.henriquebarucco.urben.infrastructure.external.http

import com.henriquebarucco.urben.domain.percentage.gateway.CurrentPercentageGateway
import com.henriquebarucco.urben.infrastructure.external.http.urben.UrbenClient
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CurrentPercentageUrbenGateway(
    private val urbenClient: UrbenClient,
) : CurrentPercentageGateway {
    private val log = LoggerFactory.getLogger(CurrentPercentageUrbenGateway::class.java)

    override fun get(accessToken: String): Double {
        val response = this.urbenClient.currentPercentage("Bearer $accessToken")

        val percentage = response.body?.porcentagemTotal ?: throw RuntimeException("Failed to get current percentage")

        log.info("Current percentage: $percentage")

        return percentage
    }
}
