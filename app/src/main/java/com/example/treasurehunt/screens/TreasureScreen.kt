package com.example.treasurehunt.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TreasureScreen(timeTaken: Long, onRestart: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("🎉 Parabéns! Você encontrou o tesouro! 🎉", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Tempo total: $timeTaken segundos")
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onRestart) {
            Text("Voltar ao início")
        }
    }
}
