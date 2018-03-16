package com.github.fgoncalves.template.di.modules.fragments.binding

import com.github.fgoncalves.template.di.ScreenScope
import com.github.fgoncalves.template.presentation.home.HomeScreen
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ScreenBindingModule {
    @ScreenScope
    @ContributesAndroidInjector
    internal abstract fun homeScreen(): HomeScreen
}
