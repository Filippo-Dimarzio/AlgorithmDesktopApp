package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import utilities.countVowelsAndConsonantsLinear

@Composable
fun vowelsAndConsonantsScreen() {
    val inputText = remember { mutableStateOf("") }
    val result = remember { mutableStateOf<Pair<Int, Int>?>(null) }

   
    val textFieldColors = TextFieldDefaults.outlinedTextFieldColors(
        textColor = Color.LightGray,
        cursorColor = Color.LightGray,
        focusedBorderColor = Color.LightGray,
        unfocusedBorderColor = Color.Gray
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2E4E2E))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Vowels & Consonants", color = Color.LightGray, style = MaterialTheme.typography.h5)

       
        OutlinedTextField(
            value = inputText.value,
            onValueChange = { inputText.value = it },
            label = { Text("Enter text", color = Color.LightGray) },
            colors = textFieldColors
        )

        Button(
            onClick = {
                result.value = countVowelsAndConsonantsLinear(inputText.value)
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF4F7942)),
            enabled = inputText.value.isNotBlank()
        ) {
            Text("Count", color = Color.LightGray)
        }

        if (result.value != null) {
    val (vowels, consonants) = result.value!!
    Text("Vowels: $vowels, Consonants: $consonants", color = Color.LightGray)
}
    }
}
