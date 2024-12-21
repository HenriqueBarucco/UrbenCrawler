package com.henriquebarucco.urben.domain.percentage

interface PercentageRepository {
    fun save(percentage: Percentage)

    fun get(): Percentage
}
