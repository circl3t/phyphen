package tb.circl3t.phyphen.ui.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import tb.circl3t.phyphen.ui.navigation.NavigationManager

@Composable
fun LoadingScreen(modifier: Modifier = Modifier, navManager: NavigationManager) {
  Text("loading screen.")
  LaunchedEffect(Unit) {
    delay(2000L)
    navManager.onFinishLoad()
  }
}
