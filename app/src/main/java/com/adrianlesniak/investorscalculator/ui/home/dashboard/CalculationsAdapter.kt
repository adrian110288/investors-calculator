package com.adrianlesniak.investorscalculator.ui.home.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adrianlesniak.investorscalculator.data.Calculation
import com.adrianlesniak.investorscalculator.databinding.ListItemCalculationBinding
import com.adrianlesniak.investorscalculator.utils.AmountFormatter

class CalculationsAdapter internal constructor(
    private val layoutInflater: LayoutInflater,
    private val amountFormatter: AmountFormatter,
    private val vm: DashboardViewModel
) : RecyclerView.Adapter<CalculationsViewHolder>() {

    private var calculations = mutableListOf<Calculation>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalculationsViewHolder {

        val binding = ListItemCalculationBinding.inflate(layoutInflater, parent, false)
        return CalculationsViewHolder(binding, vm, amountFormatter)
    }

    override fun getItemCount() = calculations.size

    override fun onBindViewHolder(holder: CalculationsViewHolder, position: Int) {
        val calculation = calculations[position]
        holder.bind(calculation)
    }

    fun addItems(newCalculations: List<Calculation>) {
        calculations.apply {
            clear()
            addAll(newCalculations)
        }
        notifyDataSetChanged()
    }
}