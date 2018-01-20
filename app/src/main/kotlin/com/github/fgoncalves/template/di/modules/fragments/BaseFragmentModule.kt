package com.github.fgoncalves.template.di.modules.fragments

import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module

@Module
abstract class BaseFragmentModule<in F : Fragment> {

    @Binds
    abstract fun fragment(fragment: F): Fragment
}
