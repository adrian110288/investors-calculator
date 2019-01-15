package com.adrianlesniak.investorscalculator.ui.calculation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adrianlesniak.investorscalculator.data.CalculationsRepository
import com.adrianlesniak.investorscalculator.data.CalculationsRepositoryImpl

class NewCalculationViewModelFactory(private val repository: CalculationsRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(NewCalculationViewModel::class.java)) {
            NewCalculationViewModel(this.repository as CalculationsRepositoryImpl) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}