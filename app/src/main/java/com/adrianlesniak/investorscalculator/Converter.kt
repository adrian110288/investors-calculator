package com.adrianlesniak.investorscalculator

import androidx.databinding.InverseMethod
import java.math.BigDecimal

object Converter {

    @InverseMethod("stringToBigDecimal")
    @JvmStatic
    fun bigDecimalToString(value: BigDecimal?): String {

        return if (value == null && value == BigDecimal.ZERO) ""
        else value?.toPlainString() ?: ""
    }

    @JvmStatic
    fun stringToBigDecimal(value: String?): BigDecimal {

        return if (value != null && value.isEmpty()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(value)
        }
    }

//    @InverseMethod("stringToInt")
//    @JvmStatic
//    fun intToString(value: Int? = 0): String {
//        return if (value == 0) "" else value.toString()
//    }
//
//    @JvmStatic
//    fun stringToInt(value: String? = "0"): Int {
//        return value!!.toInt()
//    }
//
//    @InverseMethod("stringToFloat")
//    @JvmStatic
//    fun floatToString(value: Float? = 0f): String {
//        return if (value == 0f) "" else value.toString()
//    }
//
//    @JvmStatic
//    fun stringToFloat(value: String? = "0"): Float {
//        return value!!.toFloat()
//    }
}