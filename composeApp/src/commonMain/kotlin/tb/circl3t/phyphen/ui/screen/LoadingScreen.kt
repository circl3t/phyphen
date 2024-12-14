package tb.circl3t.phyphen.ui.screen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.min
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import tb.circl3t.phyphen.ui.navigation.NavigationManager

@Composable
fun LoadingScreen(modifier: Modifier = Modifier, navManager: NavigationManager) {
  LaunchedEffect(Unit) {
    delay(whiteRayDuration.toLong() + firstRaysDuration.toLong() + secondRaysDuration.toLong())
    navManager.onFinishLoad()
  }
  Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
    MyCanvas()
  }
}

val whiteRayP1 = Offset(0f, 5f/8f)
val whiteRayP2 = Offset(0f, 4.9f/8f)
val whiteRayP3 = Offset(2.75f/8f, 3.9689f/8f)
val whiteRayP4 = Offset(2.69226f/8f, 4.0689f/8f)
val redRayP3 = Offset(5f/8f, 3.53590f/8f)
val violetRayP4 = Offset(5.5f/8f, 4.40192f/8f)
val secondRedRayP3 = Offset(8f/8f, 4f/8f)
val secondVioletRayP4 = Offset(8f/8f, 6f/8f)


val firstIncidentSurfaceStepX = (whiteRayP3.x - whiteRayP4.x) / 7f
val firstIncidentSurfaceStepY = (whiteRayP4.y - whiteRayP3.y) / 7f
val secondIncidentSurfaceStepX = (violetRayP4.x - redRayP3.x) / 7f
val secondIncidentSurfaceStepY = (violetRayP4.y - redRayP3.y) / 7f
val thirdIncidentSurfaceStepX = (secondVioletRayP4.x - secondRedRayP3.x) / 7f
val thirdIncidentSurfaceStepY = (secondVioletRayP4.y - secondRedRayP3.y) / 7f

val redRayP1 = Offset(whiteRayP3.x - firstIncidentSurfaceStepX, whiteRayP3.y + firstIncidentSurfaceStepY)
val redRayP2 = whiteRayP3
val redRayP4 = Offset(redRayP3.x + secondIncidentSurfaceStepX, redRayP3.y + secondIncidentSurfaceStepY)

val orangeRayP1 = Offset(redRayP1.x - firstIncidentSurfaceStepX, redRayP1.y + firstIncidentSurfaceStepY)
val orangeRayP2 = redRayP1
val orangeRayP3 = redRayP4
val orangeRayP4 = Offset(orangeRayP3.x + secondIncidentSurfaceStepX, orangeRayP3.y + secondIncidentSurfaceStepY)


val yellowRayP1 = Offset(orangeRayP1.x - firstIncidentSurfaceStepX, orangeRayP1.y + firstIncidentSurfaceStepY)
val yellowRayP2 = orangeRayP1
val yellowRayP3 = orangeRayP4
val yellowRayP4 = Offset(yellowRayP3.x + secondIncidentSurfaceStepX, yellowRayP3.y + secondIncidentSurfaceStepY)


val greenRayP1 = Offset(yellowRayP1.x - firstIncidentSurfaceStepX, yellowRayP1.y + firstIncidentSurfaceStepY)
val greenRayP2 = yellowRayP1
val greenRayP3 = yellowRayP4
val greenRayP4 = Offset(greenRayP3.x + secondIncidentSurfaceStepX, greenRayP3.y + secondIncidentSurfaceStepY)


val cyanRayP1 = Offset(greenRayP1.x - firstIncidentSurfaceStepX, greenRayP1.y + firstIncidentSurfaceStepY)
val cyanRayP2 = greenRayP1
val cyanRayP3 = greenRayP4
val cyanRayP4 = Offset(cyanRayP3.x + secondIncidentSurfaceStepX, cyanRayP3.y + secondIncidentSurfaceStepY)


val blueRayP1 = Offset(cyanRayP1.x - firstIncidentSurfaceStepX, cyanRayP1.y + firstIncidentSurfaceStepY)
val blueRayP2 = cyanRayP1
val blueRayP3 = cyanRayP4
val blueRayP4 = Offset(blueRayP3.x + secondIncidentSurfaceStepX, blueRayP3.y + secondIncidentSurfaceStepY)


val violetRayP1 = whiteRayP4
val violetRayP2 = blueRayP1
val violetRayP3 = blueRayP4

val secondRedRayP1 = Offset(redRayP3.x + secondIncidentSurfaceStepX, redRayP3.y + secondIncidentSurfaceStepY)
val secondRedRayP2 = redRayP3
val secondRedRayP4 = Offset(secondRedRayP3.x + thirdIncidentSurfaceStepX, secondRedRayP3.y + thirdIncidentSurfaceStepY)

val secondOrangeRayP1 = Offset(secondRedRayP1.x + secondIncidentSurfaceStepX, secondRedRayP1.y + secondIncidentSurfaceStepY)
val secondOrangeRayP2 = secondRedRayP1
val secondOrangeRayP3 = secondRedRayP4
val secondOrangeRayP4 = Offset(secondOrangeRayP3.x + thirdIncidentSurfaceStepX, secondOrangeRayP3.y + thirdIncidentSurfaceStepY)


val secondYellowRayP1 = Offset(secondOrangeRayP1.x + secondIncidentSurfaceStepX, secondOrangeRayP1.y + secondIncidentSurfaceStepY)
val secondYellowRayP2 = secondOrangeRayP1
val secondYellowRayP3 = secondOrangeRayP4
val secondYellowRayP4 = Offset(secondYellowRayP3.x + thirdIncidentSurfaceStepX, secondYellowRayP3.y + thirdIncidentSurfaceStepY)



val secondGreenRayP1 = Offset(secondYellowRayP1.x + secondIncidentSurfaceStepX, secondYellowRayP1.y + secondIncidentSurfaceStepY)
val secondGreenRayP2 = secondYellowRayP1
val secondGreenRayP3 = secondYellowRayP4
val secondGreenRayP4 = Offset(secondGreenRayP3.x + thirdIncidentSurfaceStepX, secondGreenRayP3.y + thirdIncidentSurfaceStepY)



val secondCyanRayP1 = Offset(secondGreenRayP1.x + secondIncidentSurfaceStepX, secondGreenRayP1.y + secondIncidentSurfaceStepY)
val secondCyanRayP2 = secondGreenRayP1
val secondCyanRayP3 = secondGreenRayP4
val secondCyanRayP4 = Offset(secondCyanRayP3.x + thirdIncidentSurfaceStepX, secondCyanRayP3.y + thirdIncidentSurfaceStepY)

val secondBlueRayP1 = Offset(secondCyanRayP1.x + secondIncidentSurfaceStepX, secondCyanRayP1.y + secondIncidentSurfaceStepY)
val secondBlueRayP2 = secondCyanRayP1
val secondBlueRayP3 = secondCyanRayP4
val secondBlueRayP4 = Offset(secondBlueRayP3.x + thirdIncidentSurfaceStepX, secondBlueRayP3.y + thirdIncidentSurfaceStepY)


val secondVioletRayP1 = violetRayP4
val secondVioletRayP2 = secondBlueRayP1
val secondVioletRayP3 = secondBlueRayP4

const val whiteRayDuration = 200
const val firstRaysDuration = 200
const val secondRaysDuration = 200


@Composable
fun MyCanvas(modifier: Modifier = Modifier) {
  BoxWithConstraints(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center
  ) {
    val canvasSize = min(maxWidth, maxHeight)

    val whiteP3x = remember { Animatable(whiteRayP2.x) }
    val whiteP3y = remember { Animatable(whiteRayP2.y) }
    val whiteP4x = remember { Animatable(whiteRayP1.x) }
    val whiteP4y = remember { Animatable(whiteRayP1.y) }

    val redP3x = remember { Animatable(redRayP2.x) }
    val redP3y = remember { Animatable(redRayP2.y) }
    val redP4x = remember { Animatable(redRayP1.x) }
    val redP4y = remember { Animatable(redRayP1.y) }

    val orangeP3x = remember { Animatable(orangeRayP2.x) }
    val orangeP3y = remember { Animatable(orangeRayP2.y) }
    val orangeP4x = remember { Animatable(orangeRayP1.x) }
    val orangeP4y = remember { Animatable(orangeRayP1.y) }

    val yellowP3x = remember { Animatable(yellowRayP2.x) }
    val yellowP3y = remember { Animatable(yellowRayP2.y) }
    val yellowP4x = remember { Animatable(yellowRayP1.x) }
    val yellowP4y = remember { Animatable(yellowRayP1.y) }

    val greenP3x = remember { Animatable(greenRayP2.x) }
    val greenP3y = remember { Animatable(greenRayP2.y) }
    val greenP4x = remember { Animatable(greenRayP1.x) }
    val greenP4y = remember { Animatable(greenRayP1.y) }

    val cyanP3x = remember { Animatable(cyanRayP2.x) }
    val cyanP3y = remember { Animatable(cyanRayP2.y) }
    val cyanP4x = remember { Animatable(cyanRayP1.x) }
    val cyanP4y = remember { Animatable(cyanRayP1.y) }

    val blueP3x = remember { Animatable(blueRayP2.x) }
    val blueP3y = remember { Animatable(blueRayP2.y) }
    val blueP4x = remember { Animatable(blueRayP1.x) }
    val blueP4y = remember { Animatable(blueRayP1.y) }

    val violetP3x = remember { Animatable(violetRayP2.x) }
    val violetP3y = remember { Animatable(violetRayP2.y) }
    val violetP4x = remember { Animatable(violetRayP1.x) }
    val violetP4y = remember { Animatable(violetRayP1.y) }


    val secondRedP3x = remember { Animatable(secondRedRayP2.x) }
    val secondRedP3y = remember { Animatable(secondRedRayP2.y) }
    val secondRedP4x = remember { Animatable(secondRedRayP1.x) }
    val secondRedP4y = remember { Animatable(secondRedRayP1.y) }

    val secondOrangeP3x = remember { Animatable(secondOrangeRayP2.x) }
    val secondOrangeP3y = remember { Animatable(secondOrangeRayP2.y) }
    val secondOrangeP4x = remember { Animatable(secondOrangeRayP1.x) }
    val secondOrangeP4y = remember { Animatable(secondOrangeRayP1.y) }

    val secondYellowP3x = remember { Animatable(secondYellowRayP2.x) }
    val secondYellowP3y = remember { Animatable(secondYellowRayP2.y) }
    val secondYellowP4x = remember { Animatable(secondYellowRayP1.x) }
    val secondYellowP4y = remember { Animatable(secondYellowRayP1.y) }

    val secondGreenP3x = remember { Animatable(secondGreenRayP2.x) }
    val secondGreenP3y = remember { Animatable(secondGreenRayP2.y) }
    val secondGreenP4x = remember { Animatable(secondGreenRayP1.x) }
    val secondGreenP4y = remember { Animatable(secondGreenRayP1.y) }

    val secondCyanP3x = remember { Animatable(secondCyanRayP2.x) }
    val secondCyanP3y = remember { Animatable(secondCyanRayP2.y) }
    val secondCyanP4x = remember { Animatable(secondCyanRayP1.x) }
    val secondCyanP4y = remember { Animatable(secondCyanRayP1.y) }

    val secondBlueP3x = remember { Animatable(secondBlueRayP2.x) }
    val secondBlueP3y = remember { Animatable(secondBlueRayP2.y) }
    val secondBlueP4x = remember { Animatable(secondBlueRayP1.x) }
    val secondBlueP4y = remember { Animatable(secondBlueRayP1.y) }

    val secondVioletP3x = remember { Animatable(secondVioletRayP2.x) }
    val secondVioletP3y = remember { Animatable(secondVioletRayP2.y) }
    val secondVioletP4x = remember { Animatable(secondVioletRayP1.x) }
    val secondVioletP4y = remember { Animatable(secondVioletRayP1.y) }

    LaunchedEffect(Unit) {
      launch {
        whiteP3x.animateTo(whiteRayP3.x, tween(whiteRayDuration, easing = LinearEasing))
      }
      launch {
        whiteP3y.animateTo(whiteRayP3.y, tween(whiteRayDuration, easing = LinearEasing))
      }
      launch {
        whiteP4x.animateTo(whiteRayP4.x, tween(whiteRayDuration, easing = LinearEasing))
      }
      launch {
        whiteP4y.animateTo(whiteRayP4.y, tween(whiteRayDuration, easing = LinearEasing))
      }
    }
    LaunchedEffect(Unit) {
      launch {
        redP3x.animateTo(redRayP3.x, tween(firstRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration))
      }
      launch {
        redP3y.animateTo(redRayP3.y, tween(firstRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration))
      }
      launch {
        redP4x.animateTo(redRayP4.x, tween(firstRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration))
      }
      launch {
        redP4y.animateTo(redRayP4.y, tween(firstRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration))
      }
    }
    LaunchedEffect(Unit) {
      launch {
        orangeP3x.animateTo(orangeRayP3.x, tween(firstRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration))
      }
      launch {
        orangeP3y.animateTo(orangeRayP3.y, tween(firstRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration))
      }
      launch {
        orangeP4x.animateTo(orangeRayP4.x, tween(firstRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration))
      }
      launch {
        orangeP4y.animateTo(orangeRayP4.y, tween(firstRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration))
      }
    }
    LaunchedEffect(Unit) {
      launch {
        yellowP3x.animateTo(yellowRayP3.x, tween(firstRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration))
      }
      launch {
        yellowP3y.animateTo(yellowRayP3.y, tween(firstRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration))
      }
      launch {
        yellowP4x.animateTo(yellowRayP4.x, tween(firstRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration))
      }
      launch {
        yellowP4y.animateTo(yellowRayP4.y, tween(firstRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration))
      }
    }
    LaunchedEffect(Unit) {
      launch {
        greenP3x.animateTo(greenRayP3.x, tween(firstRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration))
      }
      launch {
        greenP3y.animateTo(greenRayP3.y, tween(firstRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration))
      }
      launch {
        greenP4x.animateTo(greenRayP4.x, tween(firstRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration))
      }
      launch {
        greenP4y.animateTo(greenRayP4.y, tween(firstRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration))
      }
    }
    LaunchedEffect(Unit) {
      launch {
        cyanP3x.animateTo(cyanRayP3.x, tween(firstRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration))
      }
      launch {
        cyanP3y.animateTo(cyanRayP3.y, tween(firstRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration))
      }
      launch {
        cyanP4x.animateTo(cyanRayP4.x, tween(firstRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration))
      }
      launch {
        cyanP4y.animateTo(cyanRayP4.y, tween(firstRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration))
      }
    }
    LaunchedEffect(Unit) {
      launch {
        blueP3x.animateTo(blueRayP3.x, tween(firstRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration))
      }
      launch {
        blueP3y.animateTo(blueRayP3.y, tween(firstRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration))
      }
      launch {
        blueP4x.animateTo(blueRayP4.x, tween(firstRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration))
      }
      launch {
        blueP4y.animateTo(blueRayP4.y, tween(firstRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration))
      }
    }
    LaunchedEffect(Unit) {
      launch {
        violetP3x.animateTo(violetRayP3.x, tween(firstRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration))
      }
      launch {
        violetP3y.animateTo(violetRayP3.y, tween(firstRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration))
      }
      launch {
        violetP4x.animateTo(violetRayP4.x, tween(firstRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration))
      }
      launch {
        violetP4y.animateTo(violetRayP4.y, tween(firstRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration))
      }
    }
    LaunchedEffect(Unit) {
      launch {
        secondRedP3x.animateTo(secondRedRayP3.x, tween(secondRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration + firstRaysDuration))
      }
      launch {
        secondRedP3y.animateTo(secondRedRayP3.y, tween(secondRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration + firstRaysDuration))
      }
      launch {
        secondRedP4x.animateTo(secondRedRayP4.x, tween(secondRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration + firstRaysDuration))
      }
      launch {
        secondRedP4y.animateTo(secondRedRayP4.y, tween(secondRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration + firstRaysDuration))
      }
    }
    LaunchedEffect(Unit) {
      launch {
        secondOrangeP3x.animateTo(secondOrangeRayP3.x, tween(secondRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration + firstRaysDuration))
      }
      launch {
        secondOrangeP3y.animateTo(secondOrangeRayP3.y, tween(secondRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration + firstRaysDuration))
      }
      launch {
        secondOrangeP4x.animateTo(secondOrangeRayP4.x, tween(secondRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration + firstRaysDuration))
      }
      launch {
        secondOrangeP4y.animateTo(secondOrangeRayP4.y, tween(secondRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration + firstRaysDuration))
      }
    }
    LaunchedEffect(Unit) {
      launch {
        secondYellowP3x.animateTo(secondYellowRayP3.x, tween(secondRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration + firstRaysDuration))
      }
      launch {
        secondYellowP3y.animateTo(secondYellowRayP3.y, tween(secondRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration + firstRaysDuration))
      }
      launch {
        secondYellowP4x.animateTo(secondYellowRayP4.x, tween(secondRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration + firstRaysDuration))
      }
      launch {
        secondYellowP4y.animateTo(secondYellowRayP4.y, tween(secondRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration + firstRaysDuration))
      }
    }
    LaunchedEffect(Unit) {
      launch {
        secondGreenP3x.animateTo(secondGreenRayP3.x, tween(secondRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration + firstRaysDuration))
      }
      launch {
        secondGreenP3y.animateTo(secondGreenRayP3.y, tween(secondRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration + firstRaysDuration))
      }
      launch {
        secondGreenP4x.animateTo(secondGreenRayP4.x, tween(secondRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration + firstRaysDuration))
      }
      launch {
        secondGreenP4y.animateTo(secondGreenRayP4.y, tween(secondRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration + firstRaysDuration))
      }
    }
    LaunchedEffect(Unit) {
      launch {
        secondCyanP3x.animateTo(secondCyanRayP3.x, tween(secondRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration + firstRaysDuration))
      }
      launch {
        secondCyanP3y.animateTo(secondCyanRayP3.y, tween(secondRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration + firstRaysDuration))
      }
      launch {
        secondCyanP4x.animateTo(secondCyanRayP4.x, tween(secondRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration + firstRaysDuration))
      }
      launch {
        secondCyanP4y.animateTo(secondCyanRayP4.y, tween(secondRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration + firstRaysDuration))
      }
    }
    LaunchedEffect(Unit) {
      launch {
        secondBlueP3x.animateTo(secondBlueRayP3.x, tween(secondRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration + firstRaysDuration))
      }
      launch {
        secondBlueP3y.animateTo(secondBlueRayP3.y, tween(secondRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration + firstRaysDuration))
      }
      launch {
        secondBlueP4x.animateTo(secondBlueRayP4.x, tween(secondRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration + firstRaysDuration))
      }
      launch {
        secondBlueP4y.animateTo(secondBlueRayP4.y, tween(secondRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration + firstRaysDuration))
      }
    }
    LaunchedEffect(Unit) {
      launch {
        secondVioletP3x.animateTo(secondVioletRayP3.x, tween(secondRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration + firstRaysDuration))
      }
      launch {
        secondVioletP3y.animateTo(secondVioletRayP3.y, tween(secondRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration + firstRaysDuration))
      }
      launch {
        secondVioletP4x.animateTo(secondVioletRayP4.x, tween(secondRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration + firstRaysDuration))
      }
      launch {
        secondVioletP4y.animateTo(secondVioletRayP4.y, tween(secondRaysDuration, easing = LinearEasing, delayMillis = whiteRayDuration + firstRaysDuration))
      }
    }


    Canvas(modifier = modifier.size(canvasSize).background(Color.Black)) {

      drawPath(
        path = whiteRayPath(size.width, whiteP3x.value, whiteP3y.value, whiteP4x.value, whiteP4y.value),
        color = Color.White,
        style = Fill
      )
      drawPath(
        path = redRayPath(size.width, redP3x.value, redP3y.value, redP4x.value, redP4y.value),
        color = Color.Red,
        style = Fill
      )
      drawPath(
        path = orangeRayPath(size.width, orangeP3x.value, orangeP3y.value, orangeP4x.value, orangeP4y.value),
        color = Color(255, 165, 0),
        style = Fill
      )
      drawPath(
        path = yellowRayPath(size.width, yellowP3x.value, yellowP3y.value, yellowP4x.value, yellowP4y.value),
        color = Color.Yellow,
        style = Fill
      )
      drawPath(
        path = greenRayPath(size.width, greenP3x.value, greenP3y.value, greenP4x.value, greenP4y.value),
        color = Color.Green,
        style = Fill
      )
      drawPath(
        path = cyanRayPath(size.width, cyanP3x.value, cyanP3y.value, cyanP4x.value, cyanP4y.value),
        color = Color.Cyan,
        style = Fill
      )
      drawPath(
        path = blueRayPath(size.width, blueP3x.value, blueP3y.value, blueP4x.value, blueP4y.value),
        color = Color.Blue,
        style = Fill
      )
      drawPath(
        path = violetRayPath(size.width, violetP3x.value, violetP3y.value, violetP4x.value, violetP4y.value),
        color = Color(139, 0, 255),
        style = Fill
      )
      drawPath(
        path = secondRedRayPath(size.width, secondRedP3x.value, secondRedP3y.value, secondRedP4x.value, secondRedP4y.value),
        color = Color.Red,
        style = Fill
      )
      drawPath(
        path = secondOrangeRayPath(size.width, secondOrangeP3x.value, secondOrangeP3y.value, secondOrangeP4x.value, secondOrangeP4y.value),
        color = Color(255, 165, 0),
        style = Fill
      )
      drawPath(
        path = secondYellowRayPath(size.width, secondYellowP3x.value, secondYellowP3y.value, secondYellowP4x.value, secondYellowP4y.value),
        color = Color.Yellow,
        style = Fill
      )
      drawPath(
        path = secondGreenRayPath(size.width, secondGreenP3x.value, secondGreenP3y.value, secondGreenP4x.value, secondGreenP4y.value),
        color = Color.Green,
        style = Fill
      )
      drawPath(
        path = secondCyanRayPath(size.width, secondCyanP3x.value, secondCyanP3y.value, secondCyanP4x.value, secondCyanP4y.value),
        color = Color.Cyan,
        style = Fill
      )
      drawPath(
        path = secondBlueRayPath(size.width, secondBlueP3x.value, secondBlueP3y.value, secondBlueP4x.value, secondBlueP4y.value),
        color = Color.Blue,
        style = Fill
      )
      drawPath(
        path = secondVioletRayPath(size.width, secondVioletP3x.value, secondVioletP3y.value, secondVioletP4x.value, secondVioletP4y.value),
        color = Color(139, 0, 255),
        style = Fill
      )
      drawPath(
        path = trianglePath(size.width),
        color = Color.Blue,
        style = Stroke(
          width = 2f
        )
      )
      drawPath(
        path = trianglePath(size.width),
        color = Color.Blue.copy(alpha = 0.3f),
        style = Fill
      )
    }
    Text("PhyPhen", style = MaterialTheme.typography.displayMedium)
  }
}

fun trianglePath(side: Float): Path {
    return Path().apply {
      moveTo(side*(1/8F), side*(7/8F))
      lineTo(side*(4/8F), side*(1.8039F/8))
      lineTo(side*(7/8F), side*(7/8F))
      close()
    }
}
fun whiteRayPath(side: Float, p3x: Float, p3y: Float, p4x: Float, p4y: Float): Path {
  return Path().apply {
    moveTo(side*whiteRayP1.x, side*whiteRayP1.y)
    lineTo(side*whiteRayP2.x, side*whiteRayP2.y)
    lineTo(side*p3x, side*p3y)
    lineTo(side*p4x, side*p4y)
    close()
  }
}

fun redRayPath(side: Float, p3x: Float, p3y: Float, p4x: Float, p4y: Float): Path {
  return Path().apply {
    moveTo(side*redRayP1.x, side*redRayP1.y)
    lineTo(side*redRayP2.x, side*redRayP2.y)
    lineTo(side*p3x, side*p3y)
    lineTo(side*p4x, side*p4y)
    close()
  }
}
fun orangeRayPath(side: Float, p3x: Float, p3y: Float, p4x: Float, p4y: Float): Path {
  return Path().apply {
    moveTo(side*orangeRayP1.x, side*orangeRayP1.y)
    lineTo(side*orangeRayP2.x, side*orangeRayP2.y)
    lineTo(side*p3x, side*p3y)
    lineTo(side*p4x, side*p4y)
    close()
  }
}
fun yellowRayPath(side: Float, p3x: Float, p3y: Float, p4x: Float, p4y: Float): Path {
  return Path().apply {
    moveTo(side*yellowRayP1.x, side*yellowRayP1.y)
    lineTo(side*yellowRayP2.x, side*yellowRayP2.y)
    lineTo(side*p3x, side*p3y)
    lineTo(side*p4x, side*p4y)
    close()
  }
}
fun greenRayPath(side: Float, p3x: Float, p3y: Float, p4x: Float, p4y: Float): Path {
  return Path().apply {
    moveTo(side*greenRayP1.x, side*greenRayP1.y)
    lineTo(side*greenRayP2.x, side*greenRayP2.y)
    lineTo(side*p3x, side*p3y)
    lineTo(side*p4x, side*p4y)
    close()
  }
}
fun cyanRayPath(side: Float, p3x: Float, p3y: Float, p4x: Float, p4y: Float): Path {
  return Path().apply {
    moveTo(side*cyanRayP1.x, side*cyanRayP1.y)
    lineTo(side*cyanRayP2.x, side*cyanRayP2.y)
    lineTo(side*p3x, side*p3y)
    lineTo(side*p4x, side*p4y)
    close()
  }
}
fun blueRayPath(side: Float, p3x: Float, p3y: Float, p4x: Float, p4y: Float): Path {
  return Path().apply {
    moveTo(side*blueRayP1.x, side*blueRayP1.y)
    lineTo(side*blueRayP2.x, side*blueRayP2.y)
    lineTo(side*p3x, side*p3y)
    lineTo(side*p4x, side*p4y)
    close()
  }
}
fun violetRayPath(side: Float, p3x: Float, p3y: Float, p4x: Float, p4y: Float): Path {
  return Path().apply {
    moveTo(side*violetRayP1.x, side*violetRayP1.y)
    lineTo(side*violetRayP2.x, side*violetRayP2.y)
    lineTo(side*p3x, side*p3y)
    lineTo(side*p4x, side*p4y)
    close()
  }
}

fun secondRedRayPath(side: Float, p3x: Float, p3y: Float, p4x: Float, p4y: Float): Path {
  return Path().apply {
    moveTo(side*secondRedRayP1.x, side*secondRedRayP1.y)
    lineTo(side*secondRedRayP2.x, side*secondRedRayP2.y)
    lineTo(side*p3x, side*p3y)
    lineTo(side*p4x, side*p4y)
    close()
  }
}
fun secondOrangeRayPath(side: Float, p3x: Float, p3y: Float, p4x: Float, p4y: Float): Path {
  return Path().apply {
    moveTo(side*secondOrangeRayP1.x, side*secondOrangeRayP1.y)
    lineTo(side*secondOrangeRayP2.x, side*secondOrangeRayP2.y)
    lineTo(side*p3x, side*p3y)
    lineTo(side*p4x, side*p4y)
    close()
  }
}
fun secondYellowRayPath(side: Float, p3x: Float, p3y: Float, p4x: Float, p4y: Float): Path {
  return Path().apply {
    moveTo(side*secondYellowRayP1.x, side*secondYellowRayP1.y)
    lineTo(side*secondYellowRayP2.x, side*secondYellowRayP2.y)
    lineTo(side*p3x, side*p3y)
    lineTo(side*p4x, side*p4y)
    close()
  }
}
fun secondGreenRayPath(side: Float, p3x: Float, p3y: Float, p4x: Float, p4y: Float): Path {
  return Path().apply {
    moveTo(side*secondGreenRayP1.x, side*secondGreenRayP1.y)
    lineTo(side*secondGreenRayP2.x, side*secondGreenRayP2.y)
    lineTo(side*p3x, side*p3y)
    lineTo(side*p4x, side*p4y)
    close()
  }
}
fun secondCyanRayPath(side: Float, p3x: Float, p3y: Float, p4x: Float, p4y: Float): Path {
  return Path().apply {
    moveTo(side*secondCyanRayP1.x, side*secondCyanRayP1.y)
    lineTo(side*secondCyanRayP2.x, side*secondCyanRayP2.y)
    lineTo(side*p3x, side*p3y)
    lineTo(side*p4x, side*p4y)
    close()
  }
}
fun secondBlueRayPath(side: Float, p3x: Float, p3y: Float, p4x: Float, p4y: Float): Path {
  return Path().apply {
    moveTo(side*secondBlueRayP1.x, side*secondBlueRayP1.y)
    lineTo(side*secondBlueRayP2.x, side*secondBlueRayP2.y)
    lineTo(side*p3x, side*p3y)
    lineTo(side*p4x, side*p4y)
    close()
  }
}
fun secondVioletRayPath(side: Float, p3x: Float, p3y: Float, p4x: Float, p4y: Float): Path {
  return Path().apply {
    moveTo(side*secondVioletRayP1.x, side*secondVioletRayP1.y)
    lineTo(side*secondVioletRayP2.x, side*secondVioletRayP2.y)
    lineTo(side*p3x, side*p3y)
    lineTo(side*p4x, side*p4y)
    close()
  }
}



