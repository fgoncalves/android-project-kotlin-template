package com.github.fgoncalves.template.di.modules

import android.arch.lifecycle.ViewModel
import com.github.fgoncalves.template.di.ActivityScope
import com.github.fgoncalves.template.di.keys.ViewModelKey
import com.github.fgoncalves.template.presentation.home.HomeViewModel
import com.github.fgoncalves.template.presentation.home.HomeViewModelImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @ActivityScope
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun providesHomeViewModel(viewModel: HomeViewModelImpl): ViewModel
}
