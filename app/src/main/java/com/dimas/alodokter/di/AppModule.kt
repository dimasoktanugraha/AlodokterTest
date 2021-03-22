package com.dimas.alodokter.di

import com.dimas.alodokter.ui.main.detail.DetailViewModel
import com.dimas.alodokter.ui.main.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}