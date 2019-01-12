package com.adrianlesniak.investorscalculator.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.adrianlesniak.investorscalculator.R
import com.adrianlesniak.investorscalculator.ui.calculation.NewCalculationActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {

            R.id.navigation_dashboard -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_settings -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nav_view.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        new_calc_fab.setOnClickListener {
            NewCalculationActivity.launch(this)
        }
    }
}
