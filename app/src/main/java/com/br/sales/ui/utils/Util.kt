package com.br.sales.ui.utils

import com.br.sales.data.Product
import com.br.sales.ui.extension.formatToMoney

class Util {
    fun getQtdTotalItems(products: List<Product>): Int {
        var qtd = 0

        products.forEach {
            qtd += it.quantity
        }

        return qtd
    }

    fun getTotalValueOrder(products: List<Product>): String {
        var total = 0f

        products.forEach {
            total += it.unitValue * it.quantity
        }

        return total.formatToMoney()
    }
}