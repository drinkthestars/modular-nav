package com.goofy.goober.nav

object Routes {

    object MilkyWay {
        val Route = object : NavRoute {
            override val startDestination: String get() = "galaxy"
            override val name: String get() = "milky-way"
        }

        object Destinations {
            val SolSystem = object : NavDestination {
                override val name: String get() = Routes.SolSystem.Route.name
            }
            val Gliese667CSystem = object : NavDestination {
                override val name: String get() = Routes.Gliese667CSystem.Route.name
            }
            val Trappist1System = object : NavDestination {
                override val name: String get() = Routes.Trappist1System.Route.name
            }
        }
    }

    object SolSystem {
        val Route = object : NavRoute {
            override val startDestination: String get() = "system"
            override val name: String get() = "sol-system"
        }

        object Destinations {
            val Mercury = object : NavDestination {
                override val name: String get() = "mercury"
            }
            val Venus = object : NavDestination {
                override val name: String get() = "venus"
            }
            val Earth = object : NavDestination {
                override val name: String get() = "earth"
            }
        }
    }

    object Gliese667CSystem {
        val Route = object : NavRoute {
            override val startDestination: String get() = "system"
            override val name: String get() = "gliese667c-system"
        }

        object Destinations {
            val Gliese667Cc = object : NavDestination {
                override val name: String get() = "gliese667cc"
            }
        }
    }

    object Trappist1System {
        val Route = object : NavRoute {
            override val startDestination: String get() = "system"
            override val name: String get() = "trappist1-system"

        }

        object Destinations {
            val Trappist1E = object : NavDestination {
                override val name: String get() = "trappist1e"
            }
        }
    }
}
