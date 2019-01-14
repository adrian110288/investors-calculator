package com.adrianlesniak.investorscalculator.data

import androidx.lifecycle.MutableLiveData

class CalculationsRepositoryImpl : CalculationsRepository {

    val calculations = MutableLiveData<List<Calculation>>()


    override fun save(calculation: Calculation) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getById(id: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAll() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(calculation: Calculation) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(calculation: Calculation) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteById(id: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}