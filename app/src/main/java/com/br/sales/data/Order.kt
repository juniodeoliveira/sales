package com.br.sales.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "table_order")
data class Order(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "client_name") val clientName: String,
    @ColumnInfo(name = "products") val products: List<Product>
) : Serializable