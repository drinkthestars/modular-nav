package com.goofy.goober.gliese667csystem

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
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.goofy.goober.nav.NavigatorBuilder
import com.goofy.goober.nav.Routes.Gliese667CSystem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

fun gliese667CGraphBuilder(): NavigatorBuilder {
    return { navigate ->
        navigation(
            startDestination = Gliese667CSystem.Route.startDestination,
            route = Gliese667CSystem.Route.name
        ) {
            composable(Gliese667CSystem.Route.startDestination) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(onClick = { navigate(Gliese667CSystem.Destinations.Gliese667Cc) }) {
                        Text("Go to Gliese667Cc")
                    }
                }
            }
            composable(Gliese667CSystem.Destinations.Gliese667Cc.name) {
                Text("Gliese667Cc! Go back")
            }
        }
    }
}

@Composable
fun Gliese667CSystem(
    modifier: Modifier = Modifier
) {
    val viewModel = hiltViewModel<Gliese667CSystemViewModel>()
    Gliese667CSystem(state = viewModel.state, modifier)
}

@Composable
private fun Gliese667CSystem(
    state: Gliese667CSystemState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(state.text)
    }
}

@HiltViewModel
class Gliese667CSystemViewModel @Inject constructor() : ViewModel() {

    val state = Gliese667CSystemState()

    init {
        viewModelScope.launch {
            state.text = "Traveling to destination..."
            delay(2_000)
            state.text = "Welcome to the Gliese667C System!"
        }
    }
}

@Stable
class Gliese667CSystemState {
    var text by mutableStateOf("")
}
