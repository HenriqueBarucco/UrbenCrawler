package com.henriquebarucco.urben.infrastructure.external.http

import com.henriquebarucco.urben.domain.percentage.gateway.CurrentPercentageGateway
import com.henriquebarucco.urben.infrastructure.external.http.urben.UrbenClient
import org.springframework.stereotype.Service

@Service
class CurrentPercentageUrbenGateway(
    private val urbenClient: UrbenClient,
) : CurrentPercentageGateway {
    override fun get(accessToken: String): Double {
        val response = this.urbenClient.currentPercentage("Bearer $accessToken")

        return response.body?.porcentagemTotal ?: throw RuntimeException("Failed to get current percentage")
    }
}
