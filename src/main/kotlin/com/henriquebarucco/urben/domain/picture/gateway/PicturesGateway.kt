package com.henriquebarucco.urben.domain.picture.gateway

import com.henriquebarucco.urben.domain.picture.Picture

interface PicturesGateway {
    fun get(accessToken: String): List<Picture>
}
