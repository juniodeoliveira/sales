package com.br.sales.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.sales.data.Order
import com.br.sales.data.Product
import com.br.sales.ui.utils.Util

class OrderDetailViewModel(private val util: Util) : ViewModel() {
    private val _listProduct = MutableLiveData<List<Product>>()
    val listProduct: LiveData<List<Product>> = _listProduct

    private val _clientName = MutableLiveData<String>()
    val clientName: LiveData<String> = _clientName

    private val _qtdTotalItems = MutableLiveData<Int>()
    val qtdTotalItems: LiveData<Int> = _qtdTotalItems

    private val _totalValueOrder = MutableLiveData<String>()
    val totalValueOrder: LiveData<String> = _totalValueOrder

    fun initialize(order: Order) {
        _clientName.value = order.clientName
        _listProduct.value = order.products
        _qtdTotalItems.value = util.getQtdTotalItems(order.products)
        _totalValueOrder.value = util.getTotalValueOrder(order.products)
    }
}