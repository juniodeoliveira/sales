package com.br.sales.di

import com.br.sales.ui.viewmodel.HomeViewModel
import com.br.sales.ui.viewmodel.OrderDetailViewModel
import com.br.sales.ui.viewmodel.SalesViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SalesViewModel(get(), Dispatchers.IO, get()) }
    viewModel { OrderDetailViewModel(get()) }
    viewModel { HomeViewModel(get()) }
}