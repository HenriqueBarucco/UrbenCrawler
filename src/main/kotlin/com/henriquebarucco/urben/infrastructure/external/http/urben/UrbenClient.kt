package com.henriquebarucco.urben.infrastructure.external.http.urben

import com.henriquebarucco.urben.infrastructure.external.http.urben.models.CurrentPercentageUrbenResponse
import com.henriquebarucco.urben.infrastructure.external.http.urben.models.LoginUrbenRequest
import com.henriquebarucco.urben.infrastructure.external.http.urben.models.LoginUrbenResponse
import com.henriquebarucco.urben.infrastructure.external.http.urben.models.PicturesUrbenResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(
    name = "urben",
    url = "\${urben.url}",
)
interface UrbenClient {
    @PostMapping("\${urben.endpoints.login}")
    fun login(
        @RequestBody request: LoginUrbenRequest,
    ): ResponseEntity<LoginUrbenResponse>

    @GetMapping("\${urben.endpoints.currentPercentage}")
    fun currentPercentage(
        @RequestHeader("Authorization") accessToken: String,
    ): ResponseEntity<CurrentPercentageUrbenResponse>

    @GetMapping("\${urben.endpoints.pictures}")
    fun pictures(
        @RequestHeader("Authorization") accessToken: String,
    ): ResponseEntity<PicturesUrbenResponse>
}
