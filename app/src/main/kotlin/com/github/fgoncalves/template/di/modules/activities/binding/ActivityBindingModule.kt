package com.github.fgoncalves.template.di.modules.activities.binding

import com.github.fgoncalves.template.di.ActivityScope
import com.github.fgoncalves.template.di.modules.activities.MainActivityModule
import com.github.fgoncalves.template.presentation.base.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    internal abstract fun mainActivity(): MainActivity
}
