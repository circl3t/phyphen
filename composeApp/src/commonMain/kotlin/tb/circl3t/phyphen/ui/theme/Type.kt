package tb.circl3t.phyphen.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.Font
import phyphen.composeapp.generated.resources.Res
import phyphen.composeapp.generated.resources.ubuntu_regular

@Composable
fun ubuntuTextStyle(fontSize: Int, lineHeight: Int, letterSpacing: Float): TextStyle {
  val ubuntu = FontFamily(Font(resource = Res.font.ubuntu_regular))
  return TextStyle(
      fontFamily = ubuntu,
      fontSize = fontSize.sp,
      lineHeight = lineHeight.sp,
      letterSpacing = letterSpacing.sp)
}

@Composable
fun provideTypography(): Typography {
  return Typography(
      displayLarge = ubuntuTextStyle(57, 64, 0f),
      displayMedium = ubuntuTextStyle(45, 52, 0f),
      displaySmall = ubuntuTextStyle(36, 44, 0f),
      headlineLarge = ubuntuTextStyle(32, 40, 0f),
      headlineMedium = ubuntuTextStyle(28, 36, 0f),
      headlineSmall = ubuntuTextStyle(24, 32, 0f),
      titleLarge = ubuntuTextStyle(22, 28, 0f),
      titleMedium = ubuntuTextStyle(16, 24, 0.15f),
      titleSmall = ubuntuTextStyle(14, 20, 0.1f),
      bodyLarge = ubuntuTextStyle(16, 24, 0.5f),
      bodyMedium = ubuntuTextStyle(14, 20, 0.25f),
      bodySmall = ubuntuTextStyle(12, 16, 0.4f),
      labelLarge = ubuntuTextStyle(14, 20, 0.1f),
      labelMedium = ubuntuTextStyle(12, 16, 0.5f),
      labelSmall = ubuntuTextStyle(11, 16, 0.5f))
}
