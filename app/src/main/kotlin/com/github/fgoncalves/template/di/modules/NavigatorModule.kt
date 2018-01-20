package com.github.fgoncalves.template.di.modules

import android.support.v4.app.FragmentManager
import com.github.fgoncalves.pathmanager.ScreenNavigator
import com.github.fgoncalves.pathmanager.ScreenNavigatorImpl
import com.github.fgoncalves.template.R
import com.github.fgoncalves.template.di.ActivityScope
import dagger.Module
import dagger.Provides

@Module
object NavigatorModule {
    @Provides
    @ActivityScope
    @JvmStatic
    fun providesScreenNavigator(fragmentManager: FragmentManager): ScreenNavigator
            = ScreenNavigatorImpl(fragmentManager, R.id.main_container)
}
