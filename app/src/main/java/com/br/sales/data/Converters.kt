package com.br.sales.data

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converters {
    @TypeConverter
    fun fromJson(json: String?): List<Product> {
        if (json == null) {
            return arrayListOf()
        }

        val listType = object : TypeToken<List<Product>>() {}.type
        return Gson().fromJson(json, listType)
    }

    @TypeConverter
    fun toJson(products: List<Product>): String {
        return Gson().toJson(products)
    }
}