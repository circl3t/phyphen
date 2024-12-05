package tb.circl3t.phyphen.ui.navigation

import androidx.navigation.NavHostController
import kotlinx.serialization.Serializable

@Serializable
sealed class Route(val routeString: String) {
  @Serializable object Load : Route("Load")

  @Serializable object Welcome : Route("Welcome")

  @Serializable object Main : Route("Main")
}

class NavigationManager(private val navController: NavHostController) {

  fun onFinishLoad() {
    navController.navigate(Route.Welcome.routeString) {
      popUpTo(navController.graph.startDestDisplayName) { inclusive = true }
      launchSingleTop = true
    }
  }

  fun navigateTo(routeString: String) {
    navController.navigate(routeString) {}
  }

  fun goBack() {
    navController.popBackStack()
  }
}
