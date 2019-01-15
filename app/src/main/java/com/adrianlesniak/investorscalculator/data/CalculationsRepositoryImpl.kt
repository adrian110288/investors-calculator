package com.adrianlesniak.investorscalculator.data

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.adrianlesniak.investorscalculator.data.db.CalculationsDao

class CalculationsRepositoryImpl(private val calculationsDao: CalculationsDao) : CalculationsRepository {

    val allCalculations: LiveData<List<Calculation>> = Transformations.map(calculationsDao.getAll()) {
        it.map { entity -> entity.toCalculation() }
    }

    @WorkerThread
    override suspend fun save(calculation: Calculation) {
        calculationsDao.save(calculation.toEntity())
    }

    override fun getById(id: Long) {
//        TODO
    }

    override fun getAll() {
//        TODO
    }

    @WorkerThread
    override suspend fun update(calculation: Calculation) {
        calculationsDao.update(calculation.toEntity())
    }

    @WorkerThread
    override suspend fun delete(calculation: Calculation) {
        calculationsDao.delete(calculation.toEntity())
    }

    @WorkerThread
    override suspend fun deleteById(id: Long) {
        calculationsDao.deleteById(id)
    }
}