package com.henriquebarucco.urben.infrastructure.external.http.urben.models

import com.fasterxml.jackson.annotation.JsonProperty

data class LoginUrbenRequest(
    val usuario: String,
    val senha: String,
    val slug: String = "default",
    @field:JsonProperty("documento_internacional")
    val documentoInternacional: Boolean = false,
)
