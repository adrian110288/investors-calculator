package com.adrianlesniak.investorscalculator.ui.home.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adrianlesniak.investorscalculator.data.CalculationsRepository
import com.adrianlesniak.investorscalculator.data.CalculationsRepositoryImpl

class DashboardViewModelFactory(private val repository: CalculationsRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(DashboardViewModel::class.java)) {
            DashboardViewModel(this.repository as CalculationsRepositoryImpl) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}