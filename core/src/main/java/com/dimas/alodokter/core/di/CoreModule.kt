package com.dimas.alodokter.core.di

import com.dimas.alodokter.core.data.DataImage
import com.dimas.alodokter.core.data.ImageRepository
import com.dimas.alodokter.core.data.SessionManager
import org.koin.dsl.module


val sessionModule = module {
    factory { SessionManager(get()) }
}

val imageModule = module {
    factory { DataImage(get()) }
}

val repositoryModule = module {
    single {
        ImageRepository(
            get()
        )
    }
}