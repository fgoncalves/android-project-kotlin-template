package com.github.fgoncalves.template.di.modules.activities

import android.support.v4.app.FragmentManager
import com.github.fgoncalves.template.di.ActivityScope
import com.github.fgoncalves.template.di.modules.NavigatorModule
import com.github.fgoncalves.template.di.modules.ViewModelModule
import com.github.fgoncalves.template.presentation.base.MainActivity
import dagger.Module
import dagger.Provides

@Module(includes = [ViewModelModule::class, NavigatorModule::class])
object MainActivityModule {
    @Provides
    @ActivityScope
    @JvmStatic
    fun providesFragmentManager(
            activity: MainActivity): FragmentManager = activity.supportFragmentManager
}
