package com.br.sales.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.br.sales.ui.utils.SingleLiveEvent
import com.br.sales.data.Order
import com.br.sales.ui.repository.SalesRepository
import kotlinx.coroutines.launch

class HomeViewModel(
    private val salesRepository: SalesRepository
) : ViewModel() {
    private val _listOrder = SingleLiveEvent<List<Order>>()
    val listOrder: SingleLiveEvent<List<Order>> = _listOrder

    fun getAllOrder() {
        viewModelScope.launch {
            salesRepository.getAllOrder().collect {
                if (it.isNotEmpty()) {
                    _listOrder.value = it
                }
            }
        }
    }
}