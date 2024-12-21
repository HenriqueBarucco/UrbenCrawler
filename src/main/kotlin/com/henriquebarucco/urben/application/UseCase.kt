package com.henriquebarucco.urben.application

interface UseCase<IN> {
    fun execute(input: IN)
}
