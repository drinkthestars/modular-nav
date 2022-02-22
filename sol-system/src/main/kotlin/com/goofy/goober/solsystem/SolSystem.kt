package com.goofy.goober.solsystem

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.goofy.goober.nav.Navigate
import com.goofy.goober.nav.NavigatorBuilder
import com.goofy.goober.nav.Routes
import com.goofy.goober.nav.Routes.Gliese667CSystem
import com.goofy.goober.nav.Routes.SolSystem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun solGraphBuilder(): NavigatorBuilder {
    return { navigate ->
        navigation(
            startDestination = SolSystem.Route.startDestination,
            route = SolSystem.Route.name
        ) {
            composable(SolSystem.Route.startDestination) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(onClick = { navigate(SolSystem.Destinations.Mercury) }) {
                        Text("Go to Mercury")
                    }
                    Button(onClick = { navigate(SolSystem.Destinations.Venus) }) {
                        Text("Go to Venus")
                    }
                    Button(onClick = { navigate(SolSystem.Destinations.Earth) }) {
                        Text("Go to Earth")
                    }
                }

            }
            composable(SolSystem.Destinations.Mercury.name) {
                Text("Mercury! Go back")
            }
            composable(SolSystem.Destinations.Venus.name) {
                Text("Venus! Go back")
            }
            composable(SolSystem.Destinations.Earth.name) {
                Text("Earth! Go back")
            }
        }
    }
}
