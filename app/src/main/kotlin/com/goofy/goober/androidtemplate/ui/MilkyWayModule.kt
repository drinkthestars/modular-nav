package com.goofy.goober.androidtemplate.ui

import com.goofy.goober.nav.NavigatorBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
object MilkyWayModule {

    @Provides
    @IntoSet
    fun provideMilkyWayNavigatorBuilder(): NavigatorBuilder {
        return milkyWayNavigatorBuilder()
    }
}
