package com.adrianlesniak.investorscalculator.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal

@Parcelize
data class Calculation(
    val lumpSum: BigDecimal,
    val monthlyContribution: BigDecimal,
    val yearsToInvest: Int,
    val averageReturns: Float,
    val total: BigDecimal
) : Parcelable {

    companion object {
        fun newCalculation() = Calculation(
            BigDecimal.ZERO,
            BigDecimal.ZERO,
            0,
            0.0f,
            BigDecimal.ZERO
        )
    }
}