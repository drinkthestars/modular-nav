package com.goofy.goober.nav

import androidx.navigation.NavGraphBuilder

typealias NavigatorBuilder = NavGraphBuilder.(navigate: Navigate) -> Unit

interface Navigate {
    operator fun invoke(destination: NavDestination)
}

interface NavDestination {
    val name: String
}

interface NavRoute {
    val startDestination: String
    val name: String
}
