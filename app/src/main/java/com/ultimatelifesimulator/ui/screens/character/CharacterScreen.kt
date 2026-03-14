package com.ultimatelifesimulator.ui.screens.character

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@Composable
fun CharacterScreen(
    viewModel: CharacterViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Text(
                text = "Character",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
        
        item {
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Primary Stats", style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.height(8.dp))
                    StatBar("Health", uiState.health, 100)
                    StatBar("Energy", uiState.energy, 100)
                    StatBar("Stress", uiState.stress, 100)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
        
        item {
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Attributes", style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.height(8.dp))
                    StatBar("Charisma", uiState.charisma, 100)
                    StatBar("Intellect", uiState.intellect, 100)
                    StatBar("Cunning", uiState.cunning, 100)
                    StatBar("Violence", uiState.violence, 100)
                    StatBar("Stealth", uiState.stealth, 100)
                    StatBar("Perception", uiState.perception, 100)
                    StatBar("Willpower", uiState.willpower, 100)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
        
        item {
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Secondary Stats", style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.height(8.dp))
                    StatBar("Reputation", uiState.reputation, 100, offset = -100)
                    Text("Wealth: $${String.format("%.2f", uiState.wealth)}")
                    StatBar("Piety", uiState.piety, 100)
                    StatBar("Heat", uiState.heat, 100)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
        
        item {
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Traits", style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.height(8.dp))
                    if (uiState.traits.isEmpty()) {
                        Text("No traits")
                    } else {
                        uiState.traits.forEach { trait ->
                            Text("• $trait")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun StatBar(
    label: String,
    value: Int,
    maxValue: Int,
    offset: Int = 0
) {
    val percentage = ((value + offset).toFloat() / maxValue.toFloat()).coerceIn(0f, 1f)
    val color = when {
        percentage > 0.6f -> MaterialTheme.colorScheme.primary
        percentage > 0.3f -> MaterialTheme.colorScheme.tertiary
        else -> MaterialTheme.colorScheme.error
    }
    
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(label, modifier = Modifier.width(100.dp))
        LinearProgressIndicator(
            progress = percentage,
            modifier = Modifier
                .weight(1f)
                .height(8.dp),
            color = color,
            trackColor = MaterialTheme.colorScheme.surfaceVariant
        )
        Text(
            text = value.toString(),
            modifier = Modifier.width(40.dp),
            textAlign = androidx.compose.ui.text.style.TextAlign.End
        )
    }
}

data class CharacterUiState(
    val health: Int = 100,
    val energy: Int = 100,
    val stress: Int = 0,
    val charisma: Int = 50,
    val intellect: Int = 50,
    val cunning: Int = 50,
    val violence: Int = 50,
    val stealth: Int = 50,
    val perception: Int = 50,
    val willpower: Int = 50,
    val reputation: Int = 0,
    val wealth: Double = 1000.0,
    val piety: Int = 50,
    val heat: Int = 0,
    val traits: List<String> = emptyList()
)

class CharacterViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CharacterUiState())
    val uiState: StateFlow<CharacterUiState> = _uiState.asStateFlow()
}
