package tb.circl3t.phyphen

import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import tb.circl3t.phyphen.di.dummyModule
import tb.circl3t.phyphen.ui.PhyPhenApp
import tb.circl3t.phyphen.ui.theme.PhyPhenTheme

@Composable
@Preview
fun App() {
  KoinApplication(application = { modules(dummyModule) }) { PhyPhenTheme { PhyPhenApp() } }
}
