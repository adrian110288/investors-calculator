package com.adrianlesniak.investorscalculator.data

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.adrianlesniak.investorscalculator.data.db.CalculationsDao

class CalculationsRepositoryImpl(private val calculationsDao: CalculationsDao) : CalculationsRepository {

    val allCalculations: LiveData<List<Calculation>> = calculationsDao.getAll()

    //    TODO Not needed?
    val singleCalculation = MutableLiveData<Calculation>()

    @WorkerThread
    override suspend fun save(calculation: Calculation) {
        calculationsDao.save(calculation)
    }

    override fun getById(id: String) {
        singleCalculation.value = calculationsDao.getById(id).value
    }

    override fun getAll() {
//        TODO
    }

    @WorkerThread
    override suspend fun update(calculation: Calculation) {
        calculationsDao.update(calculation)
    }

    @WorkerThread
    override suspend fun delete(calculation: Calculation) {
        calculationsDao.delete(calculation)
    }

    @WorkerThread
    override suspend fun deleteById(id: String) {
        calculationsDao.deleteById(id)
    }
}