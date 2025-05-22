package ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

//chatgpt
@Composable
fun TabButton(text: String, selected: Boolean, onClick: () -> Unit) {
    Tab(selected = selected, onClick = onClick) {
        Text(
            text = text,
            color = Color.White,
            modifier = Modifier
                .background(if (selected) Color(0xFF014421) else Color(0xFF2E2E2E))
                .padding(16.dp)
        )
    }
}


