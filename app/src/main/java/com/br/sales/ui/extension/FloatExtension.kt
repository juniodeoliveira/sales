package com.br.sales.ui.extension

import java.text.NumberFormat
import java.util.*

fun Float.formatToMoney(): String {
    return NumberFormat.getCurrencyInstance(Locale("pt", "BR")).format(this)
}