package com.adrianlesniak.investorscalculator

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.adrianlesniak.investorscalculator.databinding.ActivityNewCalculationBinding

class NewCalculationActivity : AppCompatActivity() {

    companion object {

        fun launch(parent: Activity) {

            Intent(parent, NewCalculationActivity::class.java).also {
                parent.startActivity(it)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityNewCalculationBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_new_calculation)

        val vm = ViewModelProviders.of(this).get(NewCalculationViewModel::class.java)

        binding.setLifecycleOwner(this)
        binding.vm = vm
    }
}
