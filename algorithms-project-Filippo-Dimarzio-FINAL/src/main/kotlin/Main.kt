import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ui.components.TabButton
import ui.vowelsAndConsonantsScreen
import utilities.MenuItem



@Composable
fun App(currentScreen: MutableState<MenuItem>) {
    Column {
        TabRow(selectedTabIndex = currentScreen.value.ordinal) {
            TabButton(
                text = "Frequency",
                selected = currentScreen.value == MenuItem.MostFrequentElement,
                onClick = { currentScreen.value = MenuItem.MostFrequentElement }
            )
            TabButton(
                text = "Vowels & Consonants",
                selected = currentScreen.value == MenuItem.LinearAlgorithm,
                onClick = { currentScreen.value = MenuItem.LinearAlgorithm }
            )
            TabButton(
                text = "Count Occurrences",
                selected = currentScreen.value == MenuItem.CountOccurrences,
                onClick = { currentScreen.value = MenuItem.CountOccurrences }
            )
            TabButton(
                text = "Largest Number",
                selected = currentScreen.value == MenuItem.FindLargestNumber,
                onClick = { currentScreen.value = MenuItem.FindLargestNumber }
            )

        }

        Box(modifier = Modifier.fillMaxSize()) {
            when (currentScreen.value) {
                MenuItem.MostFrequentElement -> mostFrequentElementScreen()
                MenuItem.LinearAlgorithm -> vowelsAndConsonantsScreen()
                MenuItem.CountOccurrences -> CountOccurrencesScreen()
                MenuItem.FindLargestNumber -> findLargestNumberScreen()
            }
        }
    }
}

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Algorithm App by Filippo Di Marzio"
    ) {
        val currentScreen = remember { mutableStateOf(MenuItem.LinearAlgorithm) }
        App(currentScreen)
    }
}
