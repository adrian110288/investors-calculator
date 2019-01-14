package com.adrianlesniak.investorscalculator.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity(tableName = "calculations")
data class CalculationEntity(
    @PrimaryKey(autoGenerate = true) val uuid: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "lump_sum") val lumpSum: BigDecimal,
    @ColumnInfo(name = "monthly_contribution") val monthlyContribution: BigDecimal,
    @ColumnInfo(name = "years_to_invest") val yearsToInvest: BigDecimal,
    @ColumnInfo(name = "average_returns") val averageReturns: BigDecimal,
    @ColumnInfo(name = "total") val total: BigDecimal
)