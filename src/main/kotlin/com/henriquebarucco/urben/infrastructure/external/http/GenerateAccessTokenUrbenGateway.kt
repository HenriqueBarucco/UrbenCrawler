package com.henriquebarucco.urben.infrastructure.external.http

import com.henriquebarucco.urben.domain.token.GenerateAccessTokenGateway
import com.henriquebarucco.urben.infrastructure.external.http.urben.UrbenClient
import com.henriquebarucco.urben.infrastructure.external.http.urben.models.LoginUrbenRequest
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class GenerateAccessTokenUrbenGateway(
    private val urbenClient: UrbenClient,
    @Value("\${urben.username}")
    private val username: String,
    @Value("\${urben.password}")
    private val password: String,
) : GenerateAccessTokenGateway {
    override fun generate(): String {
        val request =
            LoginUrbenRequest(
                usuario = username,
                senha = password,
            )

        val response = this.urbenClient.login(request)

        return response.body?.accessToken ?: throw RuntimeException("Failed to generate access token")
    }
}
