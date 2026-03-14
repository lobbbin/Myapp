package com.ultimatelifesimulator.ui.screens.career

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CareerScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Text(
                text = "Career",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
        
        item {
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Current Position", style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Unemployed")
                    Text("Looking for opportunities...")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
        
        item {
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Education", style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("High School Diploma")
                    Text("GPA: 3.0")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
        
        item {
            Text("Job Opportunities", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
        }
        
        item {
            JobCard("Retail Associate", "Retail", "Min wage", 20)
            Spacer(modifier = Modifier.height(8.dp))
            JobCard("Food Service Worker", "Restaurant", "Min wage + tips", 25)
            Spacer(modifier = Modifier.height(8.dp))
            JobCard("Intern", "Business", "Unpaid", 15)
            Spacer(modifier = Modifier.height(16.dp))
        }
        
        item {
            Text("Skills", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
        }
        
        item {
            SkillCard("Communication", 40)
            Spacer(modifier = Modifier.height(4.dp))
            SkillCard("Leadership", 20)
            Spacer(modifier = Modifier.height(4.dp))
            SkillCard("Math", 55)
        }
    }
}

@Composable
fun JobCard(title: String, sector: String, salary: String, difficulty: Int) {
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
                Text(title, style = MaterialTheme.typography.titleMedium)
                Text(sector, style = MaterialTheme.typography.bodySmall)
            }
            Column(horizontalAlignment = Alignment.End) {
                Text(salary)
                Text("Difficulty: $difficulty%", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

@Composable
fun SkillCard(name: String, level: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(name)
        Text("$level/100")
    }
}
