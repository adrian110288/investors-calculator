package com.adrianlesniak.investorscalculator.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.adrianlesniak.investorscalculator.data.Calculation

@Dao
interface CalculationsDao {

    @Insert(onConflict = REPLACE)
    fun save(calculation: Calculation)

    @Query("SELECT * FROM Calculations WHERE uuid=:id")
    fun getById(id: String): LiveData<Calculation>

    @Query("SELECT * FROM Calculations")
    fun getAll(): LiveData<List<Calculation>>

    @Update(onConflict = REPLACE)
    fun update(calculation: Calculation)

    @Delete
    fun delete(calculation: Calculation)

    @Query("DELETE FROM Calculations WHERE uuid=:id")
    fun deleteById(id: String)


}