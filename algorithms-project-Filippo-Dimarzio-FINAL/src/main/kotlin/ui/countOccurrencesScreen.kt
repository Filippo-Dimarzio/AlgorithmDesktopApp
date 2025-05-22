import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.random.Random


@Composable
fun CountOccurrencesScreen() {
    var numberItems by remember { mutableStateOf("") }
    var occurrenceMap by remember { mutableStateOf<Map<Int, Int>>(emptyMap()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2E4E2E))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Count Occurrences",
            color = Color.LightGray,
            style = MaterialTheme.typography.h6
        )

        OutlinedTextField(
            value = numberItems,
            onValueChange = { numberItems = it },
            label = { Text("Number of Items", color = Color.LightGray) },
            textStyle = androidx.compose.ui.text.TextStyle(color = Color.LightGray),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.LightGray,
                cursorColor = Color.LightGray,

            )
        )

        Button(
            onClick = {
                val num = numberItems.toIntOrNull()
                if (num != null) {
                    occurrenceMap = List(num) { Random.nextInt(0, 100) }
                        .groupingBy { it }
                        .eachCount()
                }
            },
            enabled = numberItems.isNotBlank(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF4F7942))
        ) {
            Text("Count Occurrences", color = Color.LightGray)
        }

        //chatgpt
        LazyColumn {
            items(occurrenceMap.entries.toList()) { (item, count) ->
                Text("$item: $count times", color = Color.LightGray)
            }
        }
    }
}
