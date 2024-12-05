package tb.circl3t.phyphen.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tb.circl3t.phyphen.ui.navigation.NavigationManager
import tb.circl3t.phyphen.ui.navigation.Route
import tb.circl3t.phyphen.ui.screen.LoadingScreen
import tb.circl3t.phyphen.ui.screen.MainScreen
import tb.circl3t.phyphen.ui.screen.WelcomeScreen

@Composable
fun PhyPhenApp() {
  val navController: NavHostController = rememberNavController()
  val navManager: NavigationManager = NavigationManager(navController)
  Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
    NavHost(
        navController = navController,
        startDestination = Route.Load.routeString,
        modifier = Modifier.padding(innerPadding)) {
          composable(Route.Load.routeString) { LoadingScreen(navManager = navManager) }
          composable(Route.Welcome.routeString) { WelcomeScreen(navManager = navManager) }
          composable(Route.Main.routeString) { MainScreen(navManager = navManager) }
        }
  }
}
