package practice.game.snake

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import practice.game.snake.ui.theme.SnakeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SnakeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Snake()
                }
            }
        }
    }
}

data class State(val food: Pair<Int, Int>, val snake: List<Pair<Int, Int>>)

class Game(scope: CoroutineScope) {
    private val mutableState =
        MutableStateFlow(State(food = Pair(5, 5), snake = listOf(Pair(7, 7))))

    val state:Flow<State> = mutableState

    var move = Pair(1, 0)

    init {
        scope.launch {
            var snakeLength = 4

            while (true) {
                delay(150)
                mutableState.update {
                    val newPosition = it.snake.first().let { pos ->
                        Pair(
                            pos.first + move.first,
                            pos.second + move.second
                        )
                    }
                    it.copy()
                }
            }
        }
    }
}

@Composable
fun Snake() {

}

@Preview(showBackground = true)
@Composable
fun SnakeGamePreview() {
    Snake()
}