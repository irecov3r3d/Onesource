package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import com.example.model.Chapters
import com.example.ui.theme.BronzeAccent
import com.example.ui.theme.CharcoalText
import com.example.ui.theme.DarkWood
import com.example.ui.theme.ParchmentBackground
import com.example.ui.theme.WheatSecondary

@Composable
fun ChapterDetailScreen(chapterId: String) {
    val chapter = Chapters.find { it.id == chapterId } ?: return

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp)
    ) {
        Text(
            text = chapter.title,
            style = MaterialTheme.typography.headlineMedium,
            color = DarkWood,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(color = BronzeAccent, thickness = 2.dp)
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = chapter.subtitle,
            style = MaterialTheme.typography.titleLarge,
            color = BronzeAccent,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Biblical Anchor
        chapter.biblicalAnchor?.let {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .border(
                        width = 1.dp,
                        color = BronzeAccent.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(4.dp)
                    )
                    .background(ParchmentBackground.copy(alpha = 0.5f))
                    .padding(20.dp)
            ) {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodyLarge,
                    fontStyle = FontStyle.Italic,
                    color = CharcoalText.copy(alpha = 0.8f),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        // Key Terms
        if (chapter.keyTerms.isNotEmpty()) {
            Spacer(modifier = Modifier.height(24.dp))
            Column {
                chapter.keyTerms.forEach { (term, definition) ->
                    Text(
                        text = "• $term",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold,
                        color = DarkWood
                    )
                    Text(
                        text = "  — $definition",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(start = 8.dp, bottom = 8.dp)
                    )
                }
            }
        }

        // Sections
        chapter.sections.forEach { section ->
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = section.title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = DarkWood
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = section.content,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Justify
            )
        }

        // Practices
        if (chapter.practices.isNotEmpty()) {
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Practices",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = BronzeAccent
            )
            Spacer(modifier = Modifier.height(8.dp))
            Column {
                chapter.practices.forEach { practice ->
                    Text(
                        text = "• $practice",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }
            }
        }

        // Summary
        chapter.summary?.let {
            Spacer(modifier = Modifier.height(32.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(DarkWood.copy(alpha = 0.05f))
                    .padding(16.dp)
            ) {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    color = DarkWood
                )
            }
        }

        Spacer(modifier = Modifier.height(64.dp))
    }
}
