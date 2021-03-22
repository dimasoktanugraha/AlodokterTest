package com.dimas.alodokter

import android.app.Application
import com.dimas.alodokter.core.di.imageModule
import com.dimas.alodokter.core.di.repositoryModule
import com.dimas.alodokter.core.di.sessionModule
import com.dimas.alodokter.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    sessionModule,
                    imageModule,
                    repositoryModule,
                    viewModelModule
                )
            )
        }
    }
}