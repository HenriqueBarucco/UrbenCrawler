package com.henriquebarucco.urben.domain.percentage.gateway

interface CurrentPercentageGateway {
    fun get(accessToken: String): Double
}
