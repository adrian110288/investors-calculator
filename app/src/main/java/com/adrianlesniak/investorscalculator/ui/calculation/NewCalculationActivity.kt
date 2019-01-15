package com.adrianlesniak.investorscalculator.ui.calculation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.adrianlesniak.investorscalculator.R
import com.adrianlesniak.investorscalculator.R.layout
import com.adrianlesniak.investorscalculator.data.Calculation
import com.adrianlesniak.investorscalculator.databinding.ActivityNewCalculationBinding
import kotlinx.android.synthetic.main.activity_new_calculation.*
import java.math.BigDecimal
import java.util.Date

class NewCalculationActivity : AppCompatActivity() {

    companion object {

        const val EXTRA_CALCULATION_ITEM = "EXTRA_CALCULATION_ITEM"

        fun launch(parent: Activity, calculation: Calculation? = null) {

            Intent(parent, NewCalculationActivity::class.java).apply {
                putExtra(EXTRA_CALCULATION_ITEM, calculation)
            }.also {
                parent.startActivity(it)
            }
        }
    }

    private val calculation: Calculation by lazy {
        intent.getParcelableExtra(EXTRA_CALCULATION_ITEM) ?: Calculation.newCalculation()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityNewCalculationBinding =
            DataBindingUtil.setContentView(
                this,
                layout.activity_new_calculation
            )

        setSupportActionBar(toolbar_main as Toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp)

        val vm = ViewModelProviders.of(this).get(NewCalculationViewModel::class.java)
        vm.setupWithCalculation(
            Calculation(
                null,
                "dummy name",
                BigDecimal(2000),
                BigDecimal(200),
                9,
                5.2f,
                BigDecimal(12000),
                Date()
            )
        )

        binding.setLifecycleOwner(this)
        binding.vm = vm
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.new_calculation_toolbar_menu, menu)
        return true
    }
}
