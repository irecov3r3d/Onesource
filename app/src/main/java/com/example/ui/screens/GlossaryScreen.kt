package com.example.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.model.Appendices
import com.example.model.Glossary
import com.example.ui.theme.BronzeAccent
import com.example.ui.theme.DarkWood

@Composable
fun GlossaryScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp)
    ) {
        Text(
            text = "GLOSSARY",
            style = MaterialTheme.typography.headlineMedium,
            color = DarkWood
        )
        HorizontalDivider(color = BronzeAccent, thickness = 2.dp)
        Spacer(modifier = Modifier.height(24.dp))

        Glossary.forEach { (term, definition) ->
            Column(modifier = Modifier.padding(bottom = 16.dp)) {
                Text(
                    text = term,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    color = DarkWood
                )
                Text(
                    text = definition,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "APPENDICES",
            style = MaterialTheme.typography.headlineMedium,
            color = DarkWood
        )
        HorizontalDivider(color = BronzeAccent, thickness = 2.dp)
        Spacer(modifier = Modifier.height(24.dp))

        Appendices.forEach { appendix ->
            Column(modifier = Modifier.padding(bottom = 32.dp)) {
                Text(
                    text = appendix.title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = DarkWood
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = appendix.content,
                    style = MaterialTheme.typography.bodyLarge
                )
                
                if (appendix.items.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(16.dp))
                    appendix.items.forEach { item ->
                        Text(
                            text = "• $item",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(64.dp))
    }
}
