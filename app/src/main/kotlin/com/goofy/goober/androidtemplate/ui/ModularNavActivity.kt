package com.goofy.goober.androidtemplate.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.goofy.goober.nav.NavDestination
import com.goofy.goober.nav.Navigate
import com.goofy.goober.nav.NavigatorBuilder
import com.goofy.goober.nav.Routes.MilkyWay
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ModularNavActivity : ComponentActivity() {

    @Inject
    lateinit var navigatorBuilders: Set<@JvmSuppressWildcards NavigatorBuilder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            val navigate = rememberNavigator(navController)
            Scaffold(modifier = Modifier.fillMaxSize()) {
                NavHost(
                    navController = navController,
                    startDestination = MilkyWay.Route.startDestination
                ) {
                    navigatorBuilders.forEach { builder -> this.builder(navigate) }
                }
            }
        }
    }
}

@Composable
private fun rememberNavigator(
    navController: NavController
): Navigate {
    return remember(navController) {
        object : Navigate {
            override fun invoke(destination: NavDestination) {
                navController.navigate(destination.name)
            }
        }
    }
}

fun milkyWayNavigatorBuilder(): NavigatorBuilder {
    return { navigate ->
        composable(MilkyWay.Route.startDestination) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = { navigate(MilkyWay.Destinations.Gliese667CSystem) }) {
                    Text("Go to Gliese667C System")
                }
                Button(onClick = { navigate(MilkyWay.Destinations.SolSystem) }) {
                    Text("Go to Sol System")
                }
                Button(onClick = { navigate(MilkyWay.Destinations.Trappist1System) }) {
                    Text("Go to Trappist1 System")
                }
            }
        }
    }
}
