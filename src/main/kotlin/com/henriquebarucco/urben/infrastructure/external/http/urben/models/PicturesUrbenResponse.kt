package com.henriquebarucco.urben.infrastructure.external.http.urben.models

import com.fasterxml.jackson.annotation.JsonProperty

typealias PicturesUrbenResponse = List<Root>

data class Root(
    @field:JsonProperty("idgaleria")
    val idGaleria: Long,
    val nome: String,
    @JsonProperty("data_base")
    val dataBase: String,
    @JsonProperty("data_cad")
    val dataCad: String,
    val midias: List<Midia>,
)

data class Midia(
    @field:JsonProperty("idmidia")
    val idMidia: Int,
    @field:JsonProperty("idgaleria")
    val idGaleria: Long,
    val titulo: String,
    val nome: String,
    val tamanho: Long,
    val tipo: String,
    val url: String,
)
