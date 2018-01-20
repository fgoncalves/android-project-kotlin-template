package com.github.fgoncalves.template.di.components

import com.github.fgoncalves.template.di.modules.ApplicationModule
import com.github.fgoncalves.template.KotlinTemplateApp
import com.github.fgoncalves.template.di.modules.NetworkModule
import com.github.fgoncalves.template.di.modules.activities.binding.ActivityBindingModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(modules = [
    ApplicationModule::class,
    NetworkModule::class,
    ActivityBindingModule::class,
    AndroidSupportInjectionModule::class
])
@Singleton
interface ApplicationComponent : AndroidInjector<KotlinTemplateApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<KotlinTemplateApp>()
}
