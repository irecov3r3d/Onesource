package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme =
  darkColorScheme(
    primary = WheatSecondary,
    secondary = BronzeAccent,
    tertiary = BronzeAccent,
    background = DarkLandingBackground,
    surface = DarkWood,
    onPrimary = DarkWood,
    onSecondary = White,
    onBackground = WheatSecondary,
    onSurface = WheatSecondary
  )

private val LightColorScheme =
  lightColorScheme(
    primary = DarkWood,
    secondary = BronzeAccent,
    tertiary = BronzeAccent,
    background = ParchmentBackground,
    surface = White,
    onPrimary = WheatSecondary,
    onSecondary = White,
    onBackground = CharcoalText,
    onSurface = CharcoalText
  )

@Composable
fun TheOneSourceTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  // Disable dynamic color to maintain the scholarly aesthetic
  dynamicColor: Boolean = false,
  content: @Composable () -> Unit,
) {
  val colorScheme =
    when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
        val context = LocalContext.current
        if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }

      darkTheme -> DarkColorScheme
      else -> LightColorScheme
    }

  MaterialTheme(colorScheme = colorScheme, typography = Typography, content = content)
}
