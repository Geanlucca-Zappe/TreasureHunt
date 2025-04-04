package com.example.treasurehunt.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ClueScreen(
    clue: String,
    answer: String,
    onCorrect: () -> Unit,
    onBack: () -> Unit
) {
    var userInput by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = clue, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = userInput,
            onValueChange = {
                userInput = it
                isError = false
            },
            label = { Text("Sua resposta") },
            isError = isError
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Button(onClick = {
                if (userInput.trim().lowercase() == answer.lowercase()) {
                    onCorrect()
                } else {
                    isError = true
                }
            }) {
                Text("Próxima Pista")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = onBack) {
                Text("Voltar")
            }
        }
        if (isError) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Resposta incorreta!", color = Color.Red)
        }
    }
}
