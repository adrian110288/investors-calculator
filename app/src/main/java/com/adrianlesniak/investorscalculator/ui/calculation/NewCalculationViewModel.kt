package com.adrianlesniak.investorscalculator.ui.calculation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.adrianlesniak.investorscalculator.data.Calculation
import com.adrianlesniak.investorscalculator.utils.toDoubleSafe
import com.adrianlesniak.investorscalculator.utils.toIntSafe
import java.math.BigDecimal
import java.text.NumberFormat

class NewCalculationViewModel : ViewModel() {

    val lumpSum = MutableLiveData<BigDecimal>()
    val monthlyContributions = MutableLiveData<BigDecimal>()

    //    TODO: Convert to Int type
    val yearsToInvest = MutableLiveData<String>()

    //    TODO: Convert to Int type
    val averageReturns = MutableLiveData<String>()

    private val _totalValue = MutableLiveData<BigDecimal>()
    val formattedTotalValue: LiveData<String> =
        Transformations.map(_totalValue) {

            // TODO Inject
            val numberFormat = NumberFormat.getCurrencyInstance()
            numberFormat.format(it)
        }

    init {
        _totalValue.value = BigDecimal.ZERO
    }

    fun setupWithCalculation(calculation: Calculation) {

        lumpSum.value = calculation.lumpSum
        monthlyContributions.value = calculation.monthlyContribution
        yearsToInvest.value = calculation.yearsToInvest.toString()
        averageReturns.value = calculation.averageReturns.toString()
        _totalValue.value = calculation.total
    }

    //    TODO: combineLatest with LiveData
    fun calculate() {

        val lumpSum = lumpSum.value ?: BigDecimal.ZERO
        val monthlyContributions = monthlyContributions.value ?: BigDecimal.ZERO
        val yearsToInvest = yearsToInvest.value?.toIntSafe() ?: 0
        val averageReturns = averageReturns.value?.toDoubleSafe() ?: 0.0

        val total = SimpleCalculator.from(
            lumpSum,
            monthlyContributions,
            yearsToInvest,
            averageReturns
        )
            .calculate()

        _totalValue.value = total
    }
}