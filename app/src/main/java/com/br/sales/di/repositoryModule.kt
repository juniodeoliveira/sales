package com.br.sales.di

import com.br.sales.ui.repository.SalesRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { SalesRepository(get()) }
}