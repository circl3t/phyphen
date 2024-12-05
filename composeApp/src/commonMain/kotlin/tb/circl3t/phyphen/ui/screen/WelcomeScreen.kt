package tb.circl3t.phyphen.ui.screen

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import tb.circl3t.phyphen.ui.navigation.NavigationManager
import tb.circl3t.phyphen.ui.navigation.Route

@Composable
fun WelcomeScreen(modifier: Modifier = Modifier, navManager: NavigationManager) {
  Button(onClick = { navManager.navigateTo(Route.Main.routeString) }) { Text("continue") }
}
