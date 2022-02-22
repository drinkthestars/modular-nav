package com.goofy.goober.solsystem

import com.goofy.goober.nav.NavigatorBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
object SolSystemModule {

    @Provides
    @IntoSet
    fun provideSolSystemNavigatorBuilder(): NavigatorBuilder {
        return solGraphBuilder()
    }
}
