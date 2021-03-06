package com.adrianlesniak.investorscalculator.data

interface CalculationsRepository {

    fun getById(id: Long)

    fun getAll()

    suspend fun save(calculation: Calculation)

    suspend fun update(calculation: Calculation)

    suspend fun delete(calculation: Calculation)

    suspend fun deleteById(id: Long)

}