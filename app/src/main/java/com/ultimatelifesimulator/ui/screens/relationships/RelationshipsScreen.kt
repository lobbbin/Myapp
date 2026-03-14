package com.ultimatelifesimulator.ui.screens.relationships

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RelationshipsScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Text(
                text = "Relationships",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
        
        item {
            Text("Family", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
        }
        
        item {
            RelationshipCard("Father", "Parent", 50)
            Spacer(modifier = Modifier.height(8.dp))
            RelationshipCard("Mother", "Parent", 60)
            Spacer(modifier = Modifier.height(8.dp))
            RelationshipCard("Sibling", "Sibling", 40)
            Spacer(modifier = Modifier.height(16.dp))
        }
        
        item {
            Text("Romantic", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
        }
        
        item {
            Text("No romantic relationships", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(16.dp))
        }
        
        item {
            Text("Friends", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
        }
        
        item {
            RelationshipCard("Childhood Friend", "Friend", 70)
            Spacer(modifier = Modifier.height(16.dp))
        }
        
        item {
            Text("Professional", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
        }
        
        item {
            RelationshipCard("Employer", "Boss", 30)
            Spacer(modifier = Modifier.height(16.dp))
        }
        
        item {
            Text("Enemies", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
        }
        
        item {
            Text("No enemies", style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
fun RelationshipCard(name: String, type: String, relationship: Int) {
    val color = when {
        relationship > 50 -> MaterialTheme.colorScheme.primary
        relationship > 0 -> MaterialTheme.colorScheme.tertiary
        else -> MaterialTheme.colorScheme.error
    }
    
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(name, style = MaterialTheme.typography.titleMedium)
                Text(type, style = MaterialTheme.typography.bodySmall)
            }
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = when {
                        relationship > 75 -> "Close"
                        relationship > 50 -> "Good"
                        relationship > 25 -> "Neutral"
                        relationship > 0 -> "Strained"
                        else -> "Hostile"
                    },
                    color = color
                )
                Text(
                    text = "$relationship",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}
