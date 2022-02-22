package com.goofy.goober.gliese667csystem

import com.goofy.goober.nav.NavigatorBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
object Gliese667CSystemModule {

    @Provides
    @IntoSet
    fun provideGliese667CSystemNavigatorBuilder(): NavigatorBuilder {
        return gliese667CGraphBuilder()
    }
}
