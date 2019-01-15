package com.adrianlesniak.investorscalculator.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update

@Dao
interface CalculationsDao {

    @Insert(onConflict = REPLACE)
    fun save(calculation: CalculationEntity)

    @Query("SELECT * FROM Calculations WHERE uuid=:id")
    fun getById(id: Long): LiveData<CalculationEntity>

    @Query("SELECT * FROM Calculations")
    fun getAll(): LiveData<List<CalculationEntity>>

    @Update(onConflict = REPLACE)
    fun update(calculation: CalculationEntity)

    @Delete
    fun delete(calculation: CalculationEntity)

    @Query("DELETE FROM Calculations WHERE uuid=:id")
    fun deleteById(id: Long)


}