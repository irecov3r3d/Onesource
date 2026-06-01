package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.BronzeAccent
import com.example.ui.theme.DarkLandingBackground
import com.example.ui.theme.DarkWood
import com.example.ui.theme.WheatSecondary

@Composable
fun LandingScreen(onReadChapter: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        // Hero Section
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(DarkLandingBackground)
                .padding(vertical = 80.dp, horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "THE ONE SOURCE",
                style = MaterialTheme.typography.displayLarge,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "The Biblical Map of the Seven Energy Centers",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White.copy(alpha = 0.95f),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "A Comprehensive Guide to Spiritual Anatomy",
                style = MaterialTheme.typography.bodyLarge,
                color = WheatSecondary,
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Complete Scholarly Edition • 2026",
                style = MaterialTheme.typography.labelLarge,
                color = WheatSecondary.copy(alpha = 0.7f),
                fontWeight = FontWeight.Bold
            )
        }

        // Content Section
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            Text(
                text = "PREFACE — How to Read This Book",
                style = MaterialTheme.typography.headlineMedium,
                color = DarkWood,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            HorizontalDivider(color = BronzeAccent, thickness = 2.dp)
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "This work is a manual of transformation, not a volume to be skimmed and shelved. It is a map of the human spiritual anatomy, a system that reveals how the body, mind, and soul form a single ascending architecture. Each chapter contains layers of meaning that unfold progressively as the reader deepens in practice.",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Justify
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "The recommended approach is threefold:",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            ReadingStep(
                title = "First Reading — Orientation",
                description = "Move through the book without pausing for exercises. Allow the architecture of the seven centers to reveal itself as a unified whole. You are building a cognitive map of territory you have always inhabited."
            )

            ReadingStep(
                title = "Second Reading — Integration",
                description = "Spend one week per center. Engage the practices. Speak the Hebrew terms aloud. Journal what arises. This is where the system becomes personal."
            )

            ReadingStep(
                title = "Third Reading — Embodiment",
                description = "At this stage, you are no longer studying the centers; you are living them. The Root becomes stability, the Sacral becomes flow, the Solar Plexus becomes will, the Heart becomes compassion, the Throat becomes truth, the Brow becomes vision, and the Crown becomes unity."
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "This book weaves together three strands: Biblical scholarship, Kabbalistic mysticism, and Contemporary science. These are not forced correspondences but reflections of a deeper universal pattern. The human being is the axis between heaven and earth, and every authentic tradition has preserved a fragment of this truth.",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Justify
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "The system presented here is not Jewish, Christian, Eastern, or Western. It is human. It is the inheritance of every soul seeking to understand itself in relation to the Divine.",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Justify
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { onReadChapter("ch1") },
                modifier = Modifier.fillMaxWidth().height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = DarkWood,
                    contentColor = WheatSecondary
                )
            ) {
                Text(text = "BEGIN THE JOURNEY", fontWeight = FontWeight.Bold, letterSpacing = 1.sp)
            }
            
            Spacer(modifier = Modifier.height(48.dp))
        }
    }
}

@Composable
fun ReadingStep(title: String, description: String) {
    Column(modifier = Modifier.padding(bottom = 16.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            color = BronzeAccent
        )
        Text(
            text = description,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Justify
        )
    }
}
