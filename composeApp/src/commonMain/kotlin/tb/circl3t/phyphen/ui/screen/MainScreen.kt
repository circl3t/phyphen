package tb.circl3t.phyphen.ui.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.compose.viewmodel.koinViewModel
import tb.circl3t.phyphen.ui.navigation.NavigationManager
import tb.circl3t.phyphen.viewmodel.MainViewModel

@Composable
fun MainScreen(modifier: Modifier = Modifier, navManager: NavigationManager) {
  val viewModel = koinViewModel<MainViewModel>()
  Text("main screen.")
}
