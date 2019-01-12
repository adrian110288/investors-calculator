package com.adrianlesniak.investorscalculator

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter

object BindingAdapters {

    @BindingAdapter("field_value")
    fun setText(view: TextView, value: Int) {
        view.text = Integer.toString(value)
    }

    @InverseBindingAdapter(attribute = "field_value")
    fun getText(view: TextView): Int {
        return Integer.parseInt(view.text.toString())
    }
}