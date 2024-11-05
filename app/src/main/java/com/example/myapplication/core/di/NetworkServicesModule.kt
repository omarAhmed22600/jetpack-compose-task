package com.example.myapplication.core.di


import com.example.myapplication.core.network.domain.exampleApi.dataSource.ExampleApiServices

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkServicesModule {

    @Provides
    @Singleton
    fun provideApiCashAdvancesApiServices(retrofit: Retrofit): ExampleApiServices =
        retrofit.create(ExampleApiServices::class.java)

}
