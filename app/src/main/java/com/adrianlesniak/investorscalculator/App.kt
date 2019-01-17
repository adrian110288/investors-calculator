package com.adrianlesniak.investorscalculator

import android.app.Application
import com.adrianlesniak.investorscalculator.data.CalculationsRepository
import com.adrianlesniak.investorscalculator.data.CalculationsRepositoryImpl
import com.adrianlesniak.investorscalculator.data.db.CalculationsDatabase
import com.adrianlesniak.investorscalculator.ui.calculation.NewCalculationViewModelFactory
import com.adrianlesniak.investorscalculator.ui.home.dashboard.DashboardViewModelFactory
import com.adrianlesniak.investorscalculator.utils.AmountFormatter
import java.text.NumberFormat

class App : Application() {

    private lateinit var _db: CalculationsDatabase
    private lateinit var _calculationsRepository: CalculationsRepository
    private lateinit var _dashboardViewModelFactory: DashboardViewModelFactory
    private lateinit var _newCalculationViewModelFactory: NewCalculationViewModelFactory
    private lateinit var _amountFormatter: AmountFormatter

    val calculationsRepository: CalculationsRepository
        get() = _calculationsRepository

    val dashboardViewModelFactory: DashboardViewModelFactory
        get() = _dashboardViewModelFactory

    val newCalculationViewModelFactory: NewCalculationViewModelFactory
        get() = _newCalculationViewModelFactory

    val amountFormatter: AmountFormatter
        get() = _amountFormatter

    override fun onCreate() {
        super.onCreate()

        _db = CalculationsDatabase.getDatabase(this)
        _calculationsRepository = CalculationsRepositoryImpl(_db.userDao())
        _dashboardViewModelFactory = DashboardViewModelFactory(_calculationsRepository)
        _newCalculationViewModelFactory = NewCalculationViewModelFactory(_calculationsRepository)
        _amountFormatter = AmountFormatter(NumberFormat.getCurrencyInstance())
    }


}