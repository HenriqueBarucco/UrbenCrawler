package com.henriquebarucco.urben.application.urben

import com.henriquebarucco.urben.application.UseCase

interface VerifyUrbenNewPicturesUseCase : UseCase<String> {
    override fun execute(token: String)
}
