package com.adrianlesniak.investorscalculator.data.db.converters

import androidx.room.TypeConverter
import java.math.BigDecimal

class BigDecimalConverter {

    @TypeConverter
    fun fromLong(value: Long): BigDecimal {
        return BigDecimal(value).divide(BigDecimal(100))
    }

    @TypeConverter
    fun toLong(bigDecimal: BigDecimal): Long {
        return bigDecimal.multiply(BigDecimal(100)).longValueExact()
    }
}