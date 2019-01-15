package com.adrianlesniak.investorscalculator.ui.home.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.adrianlesniak.investorscalculator.data.Calculation
import com.adrianlesniak.investorscalculator.data.CalculationsRepositoryImpl

class DashboardViewModel(private val repository: CalculationsRepositoryImpl) : ViewModel() {

    val calculations: LiveData<List<Calculation>> = repository.allCalculations
}
