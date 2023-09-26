package com.br.sales.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.br.sales.ui.utils.SingleLiveEvent
import com.br.sales.data.Order
import com.br.sales.data.Product
import com.br.sales.ui.repository.SalesRepository
import com.br.sales.ui.utils.Util
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class SalesViewModel(
    private val salesRepository: SalesRepository,
    private val coroutineDispatcher: CoroutineDispatcher,
    private val util: Util
) : ViewModel() {
    private val _listProduct = SingleLiveEvent<MutableList<Product>>()
    val listProduct: SingleLiveEvent<MutableList<Product>> = _listProduct

    private val _qtdTotalItems = SingleLiveEvent<Int>()
    val qtdTotalItems: SingleLiveEvent<Int> = _qtdTotalItems

    private val _totalValueOrder = SingleLiveEvent<String>()
    val totalValueOrder: SingleLiveEvent<String> = _totalValueOrder

    init {
        clearListProduct()
    }

    fun clearListProduct() {
        _listProduct.value = arrayListOf()
    }

    fun addProduct(productName: String, quantity: String, valueUnit: String) {
        if (productName.isEmpty() || quantity.isEmpty() || valueUnit.isEmpty()) {
            return
        }

        val qtd = quantity.toInt()
        val value = valueUnit.toFloat()

        _listProduct.value?.add(Product(productName, qtd, value))
        _listProduct.value = _listProduct.value

        _listProduct.value?.let {
            _qtdTotalItems.value = util.getQtdTotalItems(it)
            _totalValueOrder.value = util.getTotalValueOrder(it)
        }
    }

    fun saveOrder(clientName: String) {
        _listProduct.value?.let {
            if (it.isNotEmpty() && clientName.isNotEmpty()) {
                viewModelScope.launch(coroutineDispatcher) {
                    salesRepository.saveOrder(
                        Order(
                            clientName = clientName,
                            products = it
                        )
                    )
                }
            }
        }
    }
}