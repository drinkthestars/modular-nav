package com.goofy.goober.trappist1system

import com.goofy.goober.nav.NavigatorBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
object Trappist1SystemModule {

    @Provides
    @IntoSet
    fun provideTrappist1SystemNavigatorBuilder(): NavigatorBuilder {
        return trappist1GraphBuilder()
    }
}
