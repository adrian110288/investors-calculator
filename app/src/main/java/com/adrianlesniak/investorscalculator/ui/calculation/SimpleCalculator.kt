package com.adrianlesniak.investorscalculator.ui.calculation

import com.adrianlesniak.investorscalculator.utils.Calculator
import com.adrianlesniak.investorscalculator.utils.times
import java.math.BigDecimal

class SimpleCalculator private constructor(
    private val lumpSum: BigDecimal,
    private val monthlyContributions: BigDecimal,
    private val yearsToInvest: Int,
    private val averageReturns: Double
) : Calculator {

    companion object {

        fun from(
            lumpSum: BigDecimal,
            monthlyContributions: BigDecimal,
            yearsToInvest: Int,
            averageReturns: Double
        ): SimpleCalculator {

            return SimpleCalculator(
                lumpSum,
                monthlyContributions,
                yearsToInvest,
                averageReturns
            )
        }
    }

    override fun calculate(): BigDecimal {

        var total: BigDecimal = lumpSum

        val contributionsPerYear = monthlyContributions.times(12)
        val normalizedReturns = 1 + averageReturns / 100

        repeat(yearsToInvest) {
            total += contributionsPerYear
            total = total.times(normalizedReturns)
        }

        return total.setScale(2, BigDecimal.ROUND_HALF_DOWN)
    }
}