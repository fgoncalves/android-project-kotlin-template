package com.github.fgoncalves.template.di.modules

import android.app.Application
import android.content.Context
import com.github.fgoncalves.template.di.ApplicationContext
import com.github.fgoncalves.template.KotlinTemplateApp
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class ApplicationModule {

    @Binds
    abstract fun application(app: KotlinTemplateApp): Application

    @Module
    companion object {
        @JvmStatic
        @Provides
        @ApplicationContext
        fun provideContext(application: Application): Context = application
    }
}
