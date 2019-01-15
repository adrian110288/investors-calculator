package com.adrianlesniak.investorscalculator

import android.app.Application
import com.adrianlesniak.investorscalculator.data.CalculationsRepository
import com.adrianlesniak.investorscalculator.data.CalculationsRepositoryImpl
import com.adrianlesniak.investorscalculator.data.db.CalculationsDatabase
import com.adrianlesniak.investorscalculator.ui.calculation.NewCalculationViewModelFactory
import com.adrianlesniak.investorscalculator.ui.home.dashboard.DashboardViewModelFactory

class App : Application() {

    private lateinit var _db: CalculationsDatabase
    private lateinit var _calculationsRepository: CalculationsRepository
    private lateinit var _dashboardViewModelFactory: DashboardViewModelFactory
    private lateinit var _newCalculationViewModelFactory: NewCalculationViewModelFactory

    val calculationsRepository: CalculationsRepository
        get() = _calculationsRepository

    val dashboardViewModelFactory: DashboardViewModelFactory
        get() = _dashboardViewModelFactory

    val newCalculationViewModelFactory: NewCalculationViewModelFactory
        get() = _newCalculationViewModelFactory

    override fun onCreate() {
        super.onCreate()

        _db = CalculationsDatabase.getDatabase(this)
        _calculationsRepository = CalculationsRepositoryImpl(_db.userDao())
        _dashboardViewModelFactory = DashboardViewModelFactory(_calculationsRepository)
        _newCalculationViewModelFactory = NewCalculationViewModelFactory(_calculationsRepository)
    }


}