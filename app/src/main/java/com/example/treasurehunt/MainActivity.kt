package com.example.treasurehunt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.treasurehunt.navigation.NavGraph
import com.example.treasurehunt.ui.theme.TreasureHuntTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TreasureHuntTheme {
                NavGraph()
            }
        }
    }
    }
