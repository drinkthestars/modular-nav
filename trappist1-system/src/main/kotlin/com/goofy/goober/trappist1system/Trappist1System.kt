package com.goofy.goober.trappist1system

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.goofy.goober.nav.NavigatorBuilder
import com.goofy.goober.nav.Routes.Trappist1System

fun trappist1GraphBuilder(): NavigatorBuilder {
    return { navigate ->
        navigation(
            startDestination = Trappist1System.Route.startDestination,
            route = Trappist1System.Route.name
        ) {
            composable(Trappist1System.Route.startDestination) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(onClick = { navigate(Trappist1System.Destinations.Trappist1E) }) {
                        Text("Go to Trappist1E")
                    }
                }
            }
            composable(Trappist1System.Destinations.Trappist1E.name) {
                Text("Trappist1E! Go back")
            }
        }
    }
}
