package com.henriquebarucco.urben.infrastructure.external.http.urben.models

import com.fasterxml.jackson.annotation.JsonProperty

data class CurrentPercentageUrbenResponse(
    val etapas: Etapas,
    @field:JsonProperty("porcentagem_total")
    val porcentagemTotal: Double,
)

data class Etapas(
    val name: String?,
    val porcentagem: Double,
    val peso: Int,
)
