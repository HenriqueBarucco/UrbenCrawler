package com.henriquebarucco.urben.domain.token

interface GenerateAccessTokenGateway {
    fun generate(): String
}
