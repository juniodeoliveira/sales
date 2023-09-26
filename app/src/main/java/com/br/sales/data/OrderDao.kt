package com.br.sales.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderDao {
    @Query("SELECT * FROM table_order")
    fun getAll(): Flow<List<Order>>

    @Insert
    fun insertAll(vararg order: Order)
}