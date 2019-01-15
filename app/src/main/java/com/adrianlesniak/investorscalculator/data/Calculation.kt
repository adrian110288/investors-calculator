package com.adrianlesniak.investorscalculator.data

import android.os.Parcelable
import com.adrianlesniak.investorscalculator.data.db.CalculationEntity
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal
import java.util.Date

@Parcelize
data class Calculation(
    val uuid: Long?,
    val name: String,
    val lumpSum: BigDecimal,
    val monthlyContribution: BigDecimal,
    val yearsToInvest: Int,
    val averageReturns: Float,
    val total: BigDecimal,
    val createdAt: Date?
) : Parcelable {

    companion object {

        fun newCalculation() = Calculation(
            null,
            "dummy",
            BigDecimal.ZERO,
            BigDecimal.ZERO,
            0,
            0.0f,
            BigDecimal.ZERO,
            null
        )
    }

    fun toEntity(): CalculationEntity {
        return CalculationEntity(
            uuid,
            name,
            lumpSum,
            monthlyContribution,
            yearsToInvest,
            averageReturns,
            total,
            createdAt ?: Date()
        )
    }
}