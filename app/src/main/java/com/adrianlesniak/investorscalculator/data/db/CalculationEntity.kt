package com.adrianlesniak.investorscalculator.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.adrianlesniak.investorscalculator.data.Calculation
import com.adrianlesniak.investorscalculator.data.db.converters.BigDecimalConverter
import com.adrianlesniak.investorscalculator.data.db.converters.DateConverter
import java.math.BigDecimal
import java.util.Date

@Entity(tableName = "Calculations")
@TypeConverters(BigDecimalConverter::class, DateConverter::class)
data class CalculationEntity(
    @PrimaryKey(autoGenerate = true) val uuid: Long?,
    val name: String,
    val lumpSum: BigDecimal,
    val monthlyContribution: BigDecimal,
    val yearsToInvest: Int,
    val averageReturns: Float,
    val total: BigDecimal,
    val createdAt: Date?
) {

    fun toCalculation(): Calculation {
        return Calculation(
            uuid,
            name,
            lumpSum,
            monthlyContribution,
            yearsToInvest,
            averageReturns,
            total,
            createdAt
        )
    }
}