package com.github.fgoncalves.template.di.modules.activities

import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.github.fgoncalves.template.di.ActivityContext
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class BaseActivityModule<in A : AppCompatActivity> {

    @Binds
    abstract fun activity(activity: A): AppCompatActivity

    @Module
    companion object {
        @JvmStatic
        @Provides
        @ActivityContext
        fun provideContext(activity: AppCompatActivity): Context = activity
    }
}
