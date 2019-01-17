package com.adrianlesniak.investorscalculator.ui.home.dashboard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.adrianlesniak.investorscalculator.data.Calculation
import com.adrianlesniak.investorscalculator.data.CalculationsRepositoryImpl

class DashboardViewModel(private val repository: CalculationsRepositoryImpl) : ViewModel() {

    val calculations: LiveData<List<Calculation>> = repository.allCalculations

    fun onPinClicked(calculation: Calculation) {
        Log.d("CALCULATION", calculation.toString())
    }
}
