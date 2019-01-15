package com.adrianlesniak.investorscalculator.data.db

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.adrianlesniak.investorscalculator.data.db.converters.BigDecimalConverter
import com.adrianlesniak.investorscalculator.data.db.converters.DateConverter
import java.math.BigDecimal
import java.util.Date

@Entity(tableName = "Calculations")
@TypeConverters(BigDecimalConverter::class, DateConverter::class)
data class CalculationEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    val uuid: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "lump_sum")
    val lumpSum: BigDecimal,
    @ColumnInfo(name = "monthly_contribution")
    val monthlyContribution: BigDecimal,
    @ColumnInfo(name = "years_to_invest")
    val yearsToInvest: BigDecimal,
    @ColumnInfo(name = "average_returns")
    val averageReturns: BigDecimal,
    @ColumnInfo(name = "total")
    val total: BigDecimal,
    @ColumnInfo(name = "createdAt")
    val createdAt: Date
)