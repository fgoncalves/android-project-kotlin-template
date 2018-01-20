package com.github.fgoncalves.template.di.modules

import android.content.Context
import com.github.fgoncalves.template.BuildConfig
import com.github.fgoncalves.template.di.ApplicationContext
import com.github.fgoncalves.template.di.BaseApiUrl
import com.github.fgoncalves.template.config.Config
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import javax.inject.Singleton

@Module
object NetworkModule {

    @JvmStatic
    @Provides
    @Reusable
    @BaseApiUrl
    internal fun provideBaseApiUrl() = Config.baseUrl

    @JvmStatic
    @Provides
    @Reusable
    internal fun provideLoggingInterceptor(): HttpLoggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @JvmStatic
    @Provides
    @Singleton
    internal fun provideHttp(
            @ApplicationContext context: Context,
            loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val baseClient = OkHttpClient.Builder()
                .cache(Cache(File(context.cacheDir, ".cache"), 10 * 1024 * 1024))

        if (BuildConfig.DEBUG) baseClient.addInterceptor(loggingInterceptor)

        return baseClient.build()
    }

    @JvmStatic
    @Provides
    @Singleton
    internal fun provideRetrofit(client: OkHttpClient, @BaseApiUrl baseApiUrl: String): Retrofit =
            Retrofit.Builder()
                    .baseUrl(baseApiUrl)
                    .client(client)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
}
