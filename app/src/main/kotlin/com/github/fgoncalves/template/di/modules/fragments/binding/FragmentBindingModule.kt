package com.github.fgoncalves.template.di.modules.fragments.binding

import com.github.fgoncalves.template.di.ScreenScope
import com.github.fgoncalves.template.di.modules.fragments.HomeFragmentModule
import com.github.fgoncalves.template.presentation.home.HomeScreen
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {
    @ScreenScope
    @ContributesAndroidInjector(modules = [
        HomeFragmentModule::class])
    internal abstract fun contributesHomeScreen(): HomeScreen
}
