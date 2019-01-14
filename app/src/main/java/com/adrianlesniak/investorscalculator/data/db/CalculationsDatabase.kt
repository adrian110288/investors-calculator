package com.adrianlesniak.investorscalculator.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.adrianlesniak.investorscalculator.data.db.converters.BigDecimalConverter

@Database(entities = arrayOf(CalculationEntity::class), version = 1)
@TypeConverters(BigDecimalConverter::class)
abstract class CalculationsDatabase : RoomDatabase() {
    abstract fun userDao(): CalculationsDao
}