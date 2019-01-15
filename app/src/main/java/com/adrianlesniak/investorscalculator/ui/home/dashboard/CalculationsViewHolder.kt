package com.adrianlesniak.investorscalculator.ui.home.dashboard

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.adrianlesniak.investorscalculator.data.Calculation
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item_calculation.*

class CalculationsViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    fun bind(calculation: Calculation) {
        calculation_total_tv.text = calculation.total.toString()
    }
}