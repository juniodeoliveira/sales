package com.br.sales.di

import com.br.sales.ui.utils.Util
import org.koin.dsl.module

val otherModule = module {
    single { Util() }
}