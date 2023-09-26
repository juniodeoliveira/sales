package com.br.sales.ui.repository

import com.br.sales.data.Order
import com.br.sales.data.OrderDao
import kotlinx.coroutines.flow.Flow

class SalesRepository(private val orderDao: OrderDao) {

    fun saveOrder(order: Order) {
        orderDao.insertAll(order)
    }

    fun getAllOrder(): Flow<List<Order>> {
        return orderDao.getAll()
    }
}