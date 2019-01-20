package com.adrianlesniak.investorscalculator.ui.home.dashboard

import androidx.recyclerview.widget.RecyclerView
import com.adrianlesniak.investorscalculator.data.Calculation
import com.adrianlesniak.investorscalculator.databinding.ListItemCalculationBinding
import com.adrianlesniak.investorscalculator.utils.AmountFormatter

class CalculationsViewHolder(
    private val binding: ListItemCalculationBinding,
    vm: DashboardViewModel,
    amountFormatter: AmountFormatter
) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        binding.formatter = amountFormatter
        binding.vm = vm
    }

    fun bind(calculation: Calculation) {
        binding.calculation = calculation
        binding.executePendingBindings()
    }
}