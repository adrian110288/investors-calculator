package com.adrianlesniak.investorscalculator.ui.calculation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.adrianlesniak.investorscalculator.R
import com.adrianlesniak.investorscalculator.data.Calculation
import com.adrianlesniak.investorscalculator.databinding.ActivityNewCalculationBinding
import java.math.BigDecimal

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
                R.layout.activity_new_calculation
            )

        val vm = ViewModelProviders.of(this).get(NewCalculationViewModel::class.java)
        vm.setupWithCalculation(
            Calculation(
                BigDecimal(2000),
                BigDecimal(200),
                9,
                5.2f,
                BigDecimal(12000)
            )
        )

        binding.setLifecycleOwner(this)
        binding.vm = vm
    }
}
