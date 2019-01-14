package com.adrianlesniak.investorscalculator.data

interface CalculationsRepository {

    fun save(calculation: Calculation)

    fun getById(id: String)

    fun getAll()

    fun update(calculation: Calculation)

    fun delete(calculation: Calculation)

    fun deleteById(id: String)

}