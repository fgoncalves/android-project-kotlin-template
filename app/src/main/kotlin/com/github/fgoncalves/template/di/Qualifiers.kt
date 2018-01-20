package com.github.fgoncalves.template.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityContext

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class BaseApiUrl

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationContext
