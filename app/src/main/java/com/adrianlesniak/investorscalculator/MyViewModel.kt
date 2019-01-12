package com.adrianlesniak.investorscalculator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.math.BigDecimal

class MyViewModel : ViewModel() {

    val lumpSum = MutableLiveData<BigDecimal>()
    val monthlyContributions = MutableLiveData<BigDecimal>()
    val yearsToInvest = MutableLiveData<String>()
    val averageReturns = MutableLiveData<String>()

    fun calculate() {


    }
}