package com.adrianlesniak.investorscalculator.utils

import java.math.BigDecimal
import java.text.NumberFormat

class AmountFormatter(private val numberFormat: NumberFormat) {

    fun format(amount: BigDecimal): String {
        return numberFormat.format(amount)
    }

}