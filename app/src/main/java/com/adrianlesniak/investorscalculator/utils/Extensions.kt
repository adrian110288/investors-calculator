package com.adrianlesniak.investorscalculator.utils

import java.math.BigDecimal

fun String.toIntSafe(default: Int = 0): Int {
    return toIntOrNull() ?: default
}

fun String.toDoubleSafe(default: Double = 0.0): Double {
    return toDoubleOrNull() ?: default
}

fun BigDecimal.times(value: Int): BigDecimal {
    return this.times(BigDecimal(value))
}

fun BigDecimal.times(value: Double): BigDecimal {
    return this.times(BigDecimal(value))
}