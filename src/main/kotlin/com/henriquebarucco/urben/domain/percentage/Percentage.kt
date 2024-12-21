package com.henriquebarucco.urben.domain.percentage

import java.time.Instant

data class Percentage(
    var value: Double,
    var updatedAt: Instant?,
) {
    companion object {
        fun new(): Percentage =
            Percentage(
                value = 0.0,
                updatedAt = null,
            )

        fun with(
            value: Double,
            updatedAt: Instant?,
        ): Percentage =
            Percentage(
                value = value,
                updatedAt = updatedAt,
            )
    }

    fun update(value: Double) {
        this.value = value

        this.updatedAt = Instant.now()
    }
}
