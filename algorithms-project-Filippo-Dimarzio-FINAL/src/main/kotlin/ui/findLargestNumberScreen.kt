import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun findLargestNumberScreen() {
    val numberItems = remember { mutableStateOf("") }
    val itemsList = remember { mutableStateListOf<Int>() }
    val largestNumber = remember { mutableStateOf<Int?>(null) }
    val largestNumberIndex = remember { mutableStateOf(-1) }
    val listState = rememberLazyListState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2E4E2E))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Find Largest Number", color = Color.LightGray, style = MaterialTheme.typography.h5)

        OutlinedTextField(
            value = numberItems.value,
            onValueChange = { numberItems.value = it },
            label = { Text("Number of Items", color = Color.LightGray) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.LightGray,
                cursorColor = Color.LightGray,
                focusedBorderColor = Color.LightGray,
                unfocusedBorderColor = Color.Gray
            )
        )

        Button(
            onClick = {
                val num = numberItems.value.toIntOrNull()
                if (num != null) {
                    itemsList.clear()
                    repeat(num) { itemsList.add(Random.nextInt(0, 100)) }

                    if (itemsList.isNotEmpty()) {
                        largestNumber.value = itemsList.maxOrNull()
                        largestNumberIndex.value = itemsList.indexOf(largestNumber.value)
                    } else {
                        largestNumber.value = null
                        largestNumberIndex.value = -1
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF4F7942)),
            enabled = numberItems.value.isNotBlank()
        ) {
            Text("Find Largest", color = Color.LightGray)
        }

        Text(
            text = if (largestNumberIndex.value != -1) "Largest number found at index: ${largestNumberIndex.value}" else "",
            color = Color.LightGray
        )

        Text(
            text = if (largestNumber.value != null) "Largest Number: ${largestNumber.value}" else "",
            color = Color(0xFFA7F0A7)
        )

        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxWidth()
        ) {
            itemsIndexed(itemsList) { index, item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(2.dp),
                    shape = RoundedCornerShape(4.dp),
                    border = BorderStroke(1.dp, Color.Gray),
                    backgroundColor = if (item == largestNumber.value) Color(0xFFA7F0A7) else Color(0xFF3B5D3B)
                ) {
                    Text(
                        text = "$index: $item",
                        modifier = Modifier.padding(start = 8.dp),
                        color = if (index == largestNumberIndex.value) Color.Gray else Color.LightGray
                    )
                }
            }
        }
    }
}
