package com.adrianlesniak.investorscalculator.ui.home.dashboard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adrianlesniak.investorscalculator.data.Calculation
import com.adrianlesniak.investorscalculator.data.CalculationsRepositoryImpl
import com.adrianlesniak.investorscalculator.utils.Event

class DashboardViewModel(private val repository: CalculationsRepositoryImpl) : ViewModel() {

    private val _addNewCalculationClickedEvent = MutableLiveData<Event<Boolean>>()
    val addNewCalculationClickedEvent: LiveData<Event<Boolean>>
        get() = _addNewCalculationClickedEvent

    private val _calculationItemClickedEvent = MutableLiveData<Event<Calculation>>()
    val calculationItemClickedEvent: LiveData<Event<Calculation>>
        get() = _calculationItemClickedEvent

    val calculations: LiveData<List<Calculation>> = repository.allCalculations

    fun onPinClicked(calculation: Calculation) {
        Log.d("CALCULATION", calculation.toString())
    }

    fun onAddNewCalculationButtonClicked() {
        _addNewCalculationClickedEvent.value = Event(true)
    }

    fun onCalculationItemClicked(calculation: Calculation) {
        _calculationItemClickedEvent.value = Event(calculation)
    }
}
