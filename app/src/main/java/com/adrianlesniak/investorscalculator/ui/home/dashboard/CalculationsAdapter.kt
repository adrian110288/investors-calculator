package com.adrianlesniak.investorscalculator.ui.home.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adrianlesniak.investorscalculator.R
import com.adrianlesniak.investorscalculator.data.Calculation

class CalculationsAdapter internal constructor(context: Context?) : RecyclerView.Adapter<CalculationsViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var calculations = mutableListOf<Calculation>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalculationsViewHolder {
        val itemView = inflater.inflate(R.layout.list_item_calculation, parent, false)
        return CalculationsViewHolder(itemView)
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