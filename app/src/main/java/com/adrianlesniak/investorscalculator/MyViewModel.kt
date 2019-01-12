package com.adrianlesniak.investorscalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.math.BigDecimal
import java.text.NumberFormat

class MyViewModel : ViewModel() {

    val lumpSum = MutableLiveData<BigDecimal>()
    val monthlyContributions = MutableLiveData<BigDecimal>()
    val yearsToInvest = MutableLiveData<String>()
    val averageReturns = MutableLiveData<String>()

    private val _totalValue = MutableLiveData<BigDecimal>()

    val formattedTotalValue: LiveData<String> = Transformations.map(_totalValue) {

        //        inject
        val numberFormat = NumberFormat.getCurrencyInstance()

        numberFormat.format(it)
    }

    init {
        _totalValue.value = BigDecimal.ZERO
    }

    fun calculate() {

        val lumpSum = lumpSum.value ?: BigDecimal.ZERO
        val monthlyContributions = monthlyContributions.value ?: BigDecimal.ZERO
        val yearsToInvest = yearsToInvest.value?.toIntSafe() ?: 0
        val averageReturns = averageReturns.value?.toDoubleSafe() ?: 0.0

        val total = SimpleCalculator
            .from(
                lumpSum,
                monthlyContributions,
                yearsToInvest,
                averageReturns
            )
            .calculate()

        _totalValue.value = total
    }
}