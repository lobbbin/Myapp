package com.ultimatelifesimulator.ui.screens.world

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WorldScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Text(
                text = "World",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
        
        item {
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Location", style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Current Location: Starting City")
                    Text("Region: Kingdom of Aurelia")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
        
        item {
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Factions", style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.height(8.dp))
                    FactionItem("Royal Family", 0)
                    FactionItem("Noble Houses", 10)
                    FactionItem("Merchant Guild", 20)
                    FactionItem("Church", 15)
                    FactionItem("Criminal Underworld", 0)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
        
        item {
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Economy", style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Kingdom GDP: 10,000,000")
                    Text("Inflation Rate: 2%")
                    Text("Trade Status: Stable")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
        
        item {
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Law & Order", style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Crime Rate: Low")
                    Text("Police Effectiveness: 75%")
                    Text("Corruption Level: 10%")
                }
            }
        }
    }
}

@Composable
fun FactionItem(name: String, opinion: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(name)
        Text(
            text = when {
                opinion > 50 -> "Allied"
                opinion > 20 -> "Friendly"
                opinion > -20 -> "Neutral"
                opinion > -50 -> "Unfriendly"
                else -> "Hostile"
            }
        )
    }
}
