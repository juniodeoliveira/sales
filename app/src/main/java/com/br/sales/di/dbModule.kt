package com.br.sales.di

import androidx.room.Room
import com.br.sales.data.AppDatabase
import com.br.sales.data.Converters
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val diModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java, "database-sales"
        )
            .addTypeConverter(Converters())
            .build()
    }

    single { get<AppDatabase>().orderDao() }
}