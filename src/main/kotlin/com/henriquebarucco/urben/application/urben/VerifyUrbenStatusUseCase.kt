package com.henriquebarucco.urben.application.urben

import com.henriquebarucco.urben.application.UseCase

interface VerifyUrbenStatusUseCase : UseCase<String> {
    override fun execute(token: String)
}
