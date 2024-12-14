package tb.circl3t.phyphen.viewmodel

import androidx.compose.ui.geometry.Offset
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

data class ProjectileUIState(
    val initialSpeed: Float,
    val initialAngle: Float,
    val ballOffset: Offset,
    val isAnimating: Boolean,
    val zoomScale: Float
)

class ProjectileViewModel(): ViewModel() {
    private var _uiState =
        MutableStateFlow(
            ProjectileUIState(
                initialSpeed = 18f,
                initialAngle = 1.3f,
                ballOffset = initialBallOffSet,
                isAnimating = false,
                zoomScale = 0.05f
            )
        )
}
