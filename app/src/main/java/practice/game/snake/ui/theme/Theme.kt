package practice.game.snake.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.lightColorScheme

private val ColorPalette = lightColorScheme(
    primary = DarkGreen,
//    primaryVariant = DarkGreen,
    secondary = DarkGreen,
    background = LightGreen
)

@Composable
fun SnakeTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = ColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}