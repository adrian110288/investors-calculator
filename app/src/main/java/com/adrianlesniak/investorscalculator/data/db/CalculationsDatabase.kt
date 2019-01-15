package com.adrianlesniak.investorscalculator.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CalculationEntity::class], version = 1)
abstract class CalculationsDatabase : RoomDatabase() {
    abstract fun userDao(): CalculationsDao

    companion object {
        @Volatile
        private var INSTANCE: CalculationsDatabase? = null

        fun getDatabase(context: Context): CalculationsDatabase {
            return INSTANCE ?: synchronized(this) {
                // Create database here
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CalculationsDatabase::class.java,
                    "calculations_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}