package com.henriquebarucco.urben.infrastructure.external.http.urben.models

import com.fasterxml.jackson.annotation.JsonProperty

data class LoginUrbenResponse(
    @field:JsonProperty("access_token")
    val accessToken: String,
    @field:JsonProperty("token_type")
    val tokenType: String,
    @field:JsonProperty("expires_in")
    val expiresIn: Int,
)
