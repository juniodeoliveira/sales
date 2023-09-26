package com.br.sales

import android.app.Application
import com.br.sales.di.diModule
import com.br.sales.di.otherModule
import com.br.sales.di.repositoryModule
import com.br.sales.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(listOf(diModule, repositoryModule, viewModelModule, otherModule))
        }
    }
}