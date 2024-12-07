package tb.circl3t.phyphen.ui.screen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.scale
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel
import tb.circl3t.phyphen.ui.navigation.NavigationManager
import tb.circl3t.phyphen.viewmodel.MainViewModel
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin


@Composable
fun MainScreen(modifier: Modifier = Modifier, navManager: NavigationManager) {
  val viewModel = koinViewModel<MainViewModel>()
  //Text("main screen.")
  ProjectileCanvas()
}

@Composable
fun ProjectileCanvas(modifier: Modifier = Modifier) {
  var launched by remember { mutableStateOf(false) }

  val x0 = 0f
  val y0 = 0f

  var t = remember { Animatable(0f) }

  val gravity = 9.81f
  val initialSpeed = 100f
  val initialAngle = PI / 6
  val offset: Offset = Offset((x0 + sin(initialAngle)*initialSpeed*t.value).toFloat(), (y0 + cos(initialAngle)*initialSpeed*t.value - (gravity * t.value * t.value) / 2).toFloat())

  LaunchedEffect(launched) {
    launch {
      t.animateTo(20f, animationSpec = tween(5000, easing = LinearEasing))
    }
  }


  BoxWithConstraints(
    contentAlignment = Alignment.Center,
    modifier = Modifier.fillMaxSize()
  ) {
    Canvas(modifier = Modifier.fillMaxSize()) {
      scale(scaleX = 1f, scaleY = -1f, pivot = center) {
        drawCircle(color = Color.White, radius = 5f, center = offset)
      }


      //drawCircle(color = Color.Blue, center = Offset(0f, 0f))
    }
    Text("$offset and ${t.value}")
  }
}