package com.example.compose
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.myapplication.ui.theme.backgroundDark
import com.example.myapplication.ui.theme.backgroundDarkHighContrast
import com.example.myapplication.ui.theme.backgroundDarkMediumContrast
import com.example.myapplication.ui.theme.backgroundLight
import com.example.myapplication.ui.theme.backgroundLightHighContrast
import com.example.myapplication.ui.theme.backgroundLightMediumContrast
import com.example.myapplication.ui.theme.errorContainerDark
import com.example.myapplication.ui.theme.errorContainerDarkHighContrast
import com.example.myapplication.ui.theme.errorContainerDarkMediumContrast
import com.example.myapplication.ui.theme.errorContainerLight
import com.example.myapplication.ui.theme.errorContainerLightHighContrast
import com.example.myapplication.ui.theme.errorContainerLightMediumContrast
import com.example.myapplication.ui.theme.errorDark
import com.example.myapplication.ui.theme.errorDarkHighContrast
import com.example.myapplication.ui.theme.errorDarkMediumContrast
import com.example.myapplication.ui.theme.errorLight
import com.example.myapplication.ui.theme.errorLightHighContrast
import com.example.myapplication.ui.theme.errorLightMediumContrast
import com.example.myapplication.ui.theme.inverseOnSurfaceDark
import com.example.myapplication.ui.theme.inverseOnSurfaceDarkHighContrast
import com.example.myapplication.ui.theme.inverseOnSurfaceDarkMediumContrast
import com.example.myapplication.ui.theme.inverseOnSurfaceLight
import com.example.myapplication.ui.theme.inverseOnSurfaceLightHighContrast
import com.example.myapplication.ui.theme.inverseOnSurfaceLightMediumContrast
import com.example.myapplication.ui.theme.inversePrimaryDark
import com.example.myapplication.ui.theme.inversePrimaryDarkHighContrast
import com.example.myapplication.ui.theme.inversePrimaryDarkMediumContrast
import com.example.myapplication.ui.theme.inversePrimaryLight
import com.example.myapplication.ui.theme.inversePrimaryLightHighContrast
import com.example.myapplication.ui.theme.inversePrimaryLightMediumContrast
import com.example.myapplication.ui.theme.inverseSurfaceDark
import com.example.myapplication.ui.theme.inverseSurfaceDarkHighContrast
import com.example.myapplication.ui.theme.inverseSurfaceDarkMediumContrast
import com.example.myapplication.ui.theme.inverseSurfaceLight
import com.example.myapplication.ui.theme.inverseSurfaceLightHighContrast
import com.example.myapplication.ui.theme.inverseSurfaceLightMediumContrast
import com.example.myapplication.ui.theme.onBackgroundDark
import com.example.myapplication.ui.theme.onBackgroundDarkHighContrast
import com.example.myapplication.ui.theme.onBackgroundDarkMediumContrast
import com.example.myapplication.ui.theme.onBackgroundLight
import com.example.myapplication.ui.theme.onBackgroundLightHighContrast
import com.example.myapplication.ui.theme.onBackgroundLightMediumContrast
import com.example.myapplication.ui.theme.onErrorContainerDark
import com.example.myapplication.ui.theme.onErrorContainerDarkHighContrast
import com.example.myapplication.ui.theme.onErrorContainerDarkMediumContrast
import com.example.myapplication.ui.theme.onErrorContainerLight
import com.example.myapplication.ui.theme.onErrorContainerLightHighContrast
import com.example.myapplication.ui.theme.onErrorContainerLightMediumContrast
import com.example.myapplication.ui.theme.onErrorDark
import com.example.myapplication.ui.theme.onErrorDarkHighContrast
import com.example.myapplication.ui.theme.onErrorDarkMediumContrast
import com.example.myapplication.ui.theme.onErrorLight
import com.example.myapplication.ui.theme.onErrorLightHighContrast
import com.example.myapplication.ui.theme.onErrorLightMediumContrast
import com.example.myapplication.ui.theme.onPrimaryContainerDark
import com.example.myapplication.ui.theme.onPrimaryContainerDarkHighContrast
import com.example.myapplication.ui.theme.onPrimaryContainerDarkMediumContrast
import com.example.myapplication.ui.theme.onPrimaryContainerLight
import com.example.myapplication.ui.theme.onPrimaryContainerLightHighContrast
import com.example.myapplication.ui.theme.onPrimaryContainerLightMediumContrast
import com.example.myapplication.ui.theme.onPrimaryDark
import com.example.myapplication.ui.theme.onPrimaryDarkHighContrast
import com.example.myapplication.ui.theme.onPrimaryDarkMediumContrast
import com.example.myapplication.ui.theme.onPrimaryLight
import com.example.myapplication.ui.theme.onPrimaryLightHighContrast
import com.example.myapplication.ui.theme.onPrimaryLightMediumContrast
import com.example.myapplication.ui.theme.onSecondaryContainerDark
import com.example.myapplication.ui.theme.onSecondaryContainerDarkHighContrast
import com.example.myapplication.ui.theme.onSecondaryContainerDarkMediumContrast
import com.example.myapplication.ui.theme.onSecondaryContainerLight
import com.example.myapplication.ui.theme.onSecondaryContainerLightHighContrast
import com.example.myapplication.ui.theme.onSecondaryContainerLightMediumContrast
import com.example.myapplication.ui.theme.onSecondaryDark
import com.example.myapplication.ui.theme.onSecondaryDarkHighContrast
import com.example.myapplication.ui.theme.onSecondaryDarkMediumContrast
import com.example.myapplication.ui.theme.onSecondaryLight
import com.example.myapplication.ui.theme.onSecondaryLightHighContrast
import com.example.myapplication.ui.theme.onSecondaryLightMediumContrast
import com.example.myapplication.ui.theme.onSurfaceDark
import com.example.myapplication.ui.theme.onSurfaceDarkHighContrast
import com.example.myapplication.ui.theme.onSurfaceDarkMediumContrast
import com.example.myapplication.ui.theme.onSurfaceLight
import com.example.myapplication.ui.theme.onSurfaceLightHighContrast
import com.example.myapplication.ui.theme.onSurfaceLightMediumContrast
import com.example.myapplication.ui.theme.onSurfaceVariantDark
import com.example.myapplication.ui.theme.onSurfaceVariantDarkHighContrast
import com.example.myapplication.ui.theme.onSurfaceVariantDarkMediumContrast
import com.example.myapplication.ui.theme.onSurfaceVariantLight
import com.example.myapplication.ui.theme.onSurfaceVariantLightHighContrast
import com.example.myapplication.ui.theme.onSurfaceVariantLightMediumContrast
import com.example.myapplication.ui.theme.onTertiaryContainerDark
import com.example.myapplication.ui.theme.onTertiaryContainerDarkHighContrast
import com.example.myapplication.ui.theme.onTertiaryContainerDarkMediumContrast
import com.example.myapplication.ui.theme.onTertiaryContainerLight
import com.example.myapplication.ui.theme.onTertiaryContainerLightHighContrast
import com.example.myapplication.ui.theme.onTertiaryContainerLightMediumContrast
import com.example.myapplication.ui.theme.onTertiaryDark
import com.example.myapplication.ui.theme.onTertiaryDarkHighContrast
import com.example.myapplication.ui.theme.onTertiaryDarkMediumContrast
import com.example.myapplication.ui.theme.onTertiaryLight
import com.example.myapplication.ui.theme.onTertiaryLightHighContrast
import com.example.myapplication.ui.theme.onTertiaryLightMediumContrast
import com.example.myapplication.ui.theme.outlineDark
import com.example.myapplication.ui.theme.outlineDarkHighContrast
import com.example.myapplication.ui.theme.outlineDarkMediumContrast
import com.example.myapplication.ui.theme.outlineLight
import com.example.myapplication.ui.theme.outlineLightHighContrast
import com.example.myapplication.ui.theme.outlineLightMediumContrast
import com.example.myapplication.ui.theme.outlineVariantDark
import com.example.myapplication.ui.theme.outlineVariantDarkHighContrast
import com.example.myapplication.ui.theme.outlineVariantDarkMediumContrast
import com.example.myapplication.ui.theme.outlineVariantLight
import com.example.myapplication.ui.theme.outlineVariantLightHighContrast
import com.example.myapplication.ui.theme.outlineVariantLightMediumContrast
import com.example.myapplication.ui.theme.primaryContainerDark
import com.example.myapplication.ui.theme.primaryContainerDarkHighContrast
import com.example.myapplication.ui.theme.primaryContainerDarkMediumContrast
import com.example.myapplication.ui.theme.primaryContainerLight
import com.example.myapplication.ui.theme.primaryContainerLightHighContrast
import com.example.myapplication.ui.theme.primaryContainerLightMediumContrast
import com.example.myapplication.ui.theme.primaryDark
import com.example.myapplication.ui.theme.primaryDarkHighContrast
import com.example.myapplication.ui.theme.primaryDarkMediumContrast
import com.example.myapplication.ui.theme.primaryLight
import com.example.myapplication.ui.theme.primaryLightHighContrast
import com.example.myapplication.ui.theme.primaryLightMediumContrast
import com.example.myapplication.ui.theme.scrimDark
import com.example.myapplication.ui.theme.scrimDarkHighContrast
import com.example.myapplication.ui.theme.scrimDarkMediumContrast
import com.example.myapplication.ui.theme.scrimLight
import com.example.myapplication.ui.theme.scrimLightHighContrast
import com.example.myapplication.ui.theme.scrimLightMediumContrast
import com.example.myapplication.ui.theme.secondaryContainerDark
import com.example.myapplication.ui.theme.secondaryContainerDarkHighContrast
import com.example.myapplication.ui.theme.secondaryContainerDarkMediumContrast
import com.example.myapplication.ui.theme.secondaryContainerLight
import com.example.myapplication.ui.theme.secondaryContainerLightHighContrast
import com.example.myapplication.ui.theme.secondaryContainerLightMediumContrast
import com.example.myapplication.ui.theme.secondaryDark
import com.example.myapplication.ui.theme.secondaryDarkHighContrast
import com.example.myapplication.ui.theme.secondaryDarkMediumContrast
import com.example.myapplication.ui.theme.secondaryLight
import com.example.myapplication.ui.theme.secondaryLightHighContrast
import com.example.myapplication.ui.theme.secondaryLightMediumContrast
import com.example.myapplication.ui.theme.surfaceBrightDark
import com.example.myapplication.ui.theme.surfaceBrightDarkHighContrast
import com.example.myapplication.ui.theme.surfaceBrightDarkMediumContrast
import com.example.myapplication.ui.theme.surfaceBrightLight
import com.example.myapplication.ui.theme.surfaceBrightLightHighContrast
import com.example.myapplication.ui.theme.surfaceBrightLightMediumContrast
import com.example.myapplication.ui.theme.surfaceContainerDark
import com.example.myapplication.ui.theme.surfaceContainerDarkHighContrast
import com.example.myapplication.ui.theme.surfaceContainerDarkMediumContrast
import com.example.myapplication.ui.theme.surfaceContainerHighDark
import com.example.myapplication.ui.theme.surfaceContainerHighDarkHighContrast
import com.example.myapplication.ui.theme.surfaceContainerHighDarkMediumContrast
import com.example.myapplication.ui.theme.surfaceContainerHighLight
import com.example.myapplication.ui.theme.surfaceContainerHighLightHighContrast
import com.example.myapplication.ui.theme.surfaceContainerHighLightMediumContrast
import com.example.myapplication.ui.theme.surfaceContainerHighestDark
import com.example.myapplication.ui.theme.surfaceContainerHighestDarkHighContrast
import com.example.myapplication.ui.theme.surfaceContainerHighestDarkMediumContrast
import com.example.myapplication.ui.theme.surfaceContainerHighestLight
import com.example.myapplication.ui.theme.surfaceContainerHighestLightHighContrast
import com.example.myapplication.ui.theme.surfaceContainerHighestLightMediumContrast
import com.example.myapplication.ui.theme.surfaceContainerLight
import com.example.myapplication.ui.theme.surfaceContainerLightHighContrast
import com.example.myapplication.ui.theme.surfaceContainerLightMediumContrast
import com.example.myapplication.ui.theme.surfaceContainerLowDark
import com.example.myapplication.ui.theme.surfaceContainerLowDarkHighContrast
import com.example.myapplication.ui.theme.surfaceContainerLowDarkMediumContrast
import com.example.myapplication.ui.theme.surfaceContainerLowLight
import com.example.myapplication.ui.theme.surfaceContainerLowLightHighContrast
import com.example.myapplication.ui.theme.surfaceContainerLowLightMediumContrast
import com.example.myapplication.ui.theme.surfaceContainerLowestDark
import com.example.myapplication.ui.theme.surfaceContainerLowestDarkHighContrast
import com.example.myapplication.ui.theme.surfaceContainerLowestDarkMediumContrast
import com.example.myapplication.ui.theme.surfaceContainerLowestLight
import com.example.myapplication.ui.theme.surfaceContainerLowestLightHighContrast
import com.example.myapplication.ui.theme.surfaceContainerLowestLightMediumContrast
import com.example.myapplication.ui.theme.surfaceDark
import com.example.myapplication.ui.theme.surfaceDarkHighContrast
import com.example.myapplication.ui.theme.surfaceDarkMediumContrast
import com.example.myapplication.ui.theme.surfaceDimDark
import com.example.myapplication.ui.theme.surfaceDimDarkHighContrast
import com.example.myapplication.ui.theme.surfaceDimDarkMediumContrast
import com.example.myapplication.ui.theme.surfaceDimLight
import com.example.myapplication.ui.theme.surfaceDimLightHighContrast
import com.example.myapplication.ui.theme.surfaceDimLightMediumContrast
import com.example.myapplication.ui.theme.surfaceLight
import com.example.myapplication.ui.theme.surfaceLightHighContrast
import com.example.myapplication.ui.theme.surfaceLightMediumContrast
import com.example.myapplication.ui.theme.surfaceVariantDark
import com.example.myapplication.ui.theme.surfaceVariantDarkHighContrast
import com.example.myapplication.ui.theme.surfaceVariantDarkMediumContrast
import com.example.myapplication.ui.theme.surfaceVariantLight
import com.example.myapplication.ui.theme.surfaceVariantLightHighContrast
import com.example.myapplication.ui.theme.surfaceVariantLightMediumContrast
import com.example.myapplication.ui.theme.tertiaryContainerDark
import com.example.myapplication.ui.theme.tertiaryContainerDarkHighContrast
import com.example.myapplication.ui.theme.tertiaryContainerDarkMediumContrast
import com.example.myapplication.ui.theme.tertiaryContainerLight
import com.example.myapplication.ui.theme.tertiaryContainerLightHighContrast
import com.example.myapplication.ui.theme.tertiaryContainerLightMediumContrast
import com.example.myapplication.ui.theme.tertiaryDark
import com.example.myapplication.ui.theme.tertiaryDarkHighContrast
import com.example.myapplication.ui.theme.tertiaryDarkMediumContrast
import com.example.myapplication.ui.theme.tertiaryLight
import com.example.myapplication.ui.theme.tertiaryLightHighContrast
import com.example.myapplication.ui.theme.tertiaryLightMediumContrast
import com.example.ui.theme.AppTypography

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
)

private val mediumContrastLightColorScheme = lightColorScheme(
    primary = primaryLightMediumContrast,
    onPrimary = onPrimaryLightMediumContrast,
    primaryContainer = primaryContainerLightMediumContrast,
    onPrimaryContainer = onPrimaryContainerLightMediumContrast,
    secondary = secondaryLightMediumContrast,
    onSecondary = onSecondaryLightMediumContrast,
    secondaryContainer = secondaryContainerLightMediumContrast,
    onSecondaryContainer = onSecondaryContainerLightMediumContrast,
    tertiary = tertiaryLightMediumContrast,
    onTertiary = onTertiaryLightMediumContrast,
    tertiaryContainer = tertiaryContainerLightMediumContrast,
    onTertiaryContainer = onTertiaryContainerLightMediumContrast,
    error = errorLightMediumContrast,
    onError = onErrorLightMediumContrast,
    errorContainer = errorContainerLightMediumContrast,
    onErrorContainer = onErrorContainerLightMediumContrast,
    background = backgroundLightMediumContrast,
    onBackground = onBackgroundLightMediumContrast,
    surface = surfaceLightMediumContrast,
    onSurface = onSurfaceLightMediumContrast,
    surfaceVariant = surfaceVariantLightMediumContrast,
    onSurfaceVariant = onSurfaceVariantLightMediumContrast,
    outline = outlineLightMediumContrast,
    outlineVariant = outlineVariantLightMediumContrast,
    scrim = scrimLightMediumContrast,
    inverseSurface = inverseSurfaceLightMediumContrast,
    inverseOnSurface = inverseOnSurfaceLightMediumContrast,
    inversePrimary = inversePrimaryLightMediumContrast,
)

private val highContrastLightColorScheme = lightColorScheme(
    primary = primaryLightHighContrast,
    onPrimary = onPrimaryLightHighContrast,
    primaryContainer = primaryContainerLightHighContrast,
    onPrimaryContainer = onPrimaryContainerLightHighContrast,
    secondary = secondaryLightHighContrast,
    onSecondary = onSecondaryLightHighContrast,
    secondaryContainer = secondaryContainerLightHighContrast,
    onSecondaryContainer = onSecondaryContainerLightHighContrast,
    tertiary = tertiaryLightHighContrast,
    onTertiary = onTertiaryLightHighContrast,
    tertiaryContainer = tertiaryContainerLightHighContrast,
    onTertiaryContainer = onTertiaryContainerLightHighContrast,
    error = errorLightHighContrast,
    onError = onErrorLightHighContrast,
    errorContainer = errorContainerLightHighContrast,
    onErrorContainer = onErrorContainerLightHighContrast,
    background = backgroundLightHighContrast,
    onBackground = onBackgroundLightHighContrast,
    surface = surfaceLightHighContrast,
    onSurface = onSurfaceLightHighContrast,
    surfaceVariant = surfaceVariantLightHighContrast,
    onSurfaceVariant = onSurfaceVariantLightHighContrast,
    outline = outlineLightHighContrast,
    outlineVariant = outlineVariantLightHighContrast,
    scrim = scrimLightHighContrast,
    inverseSurface = inverseSurfaceLightHighContrast,
    inverseOnSurface = inverseOnSurfaceLightHighContrast,
    inversePrimary = inversePrimaryLightHighContrast,

)

private val mediumContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkMediumContrast,
    onPrimary = onPrimaryDarkMediumContrast,
    primaryContainer = primaryContainerDarkMediumContrast,
    onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
    secondary = secondaryDarkMediumContrast,
    onSecondary = onSecondaryDarkMediumContrast,
    secondaryContainer = secondaryContainerDarkMediumContrast,
    onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
    tertiary = tertiaryDarkMediumContrast,
    onTertiary = onTertiaryDarkMediumContrast,
    tertiaryContainer = tertiaryContainerDarkMediumContrast,
    onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
    error = errorDarkMediumContrast,
    onError = onErrorDarkMediumContrast,
    errorContainer = errorContainerDarkMediumContrast,
    onErrorContainer = onErrorContainerDarkMediumContrast,
    background = backgroundDarkMediumContrast,
    onBackground = onBackgroundDarkMediumContrast,
    surface = surfaceDarkMediumContrast,
    onSurface = onSurfaceDarkMediumContrast,
    surfaceVariant = surfaceVariantDarkMediumContrast,
    onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
    outline = outlineDarkMediumContrast,
    outlineVariant = outlineVariantDarkMediumContrast,
    scrim = scrimDarkMediumContrast,
    inverseSurface = inverseSurfaceDarkMediumContrast,
    inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
    inversePrimary = inversePrimaryDarkMediumContrast,
)

private val highContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkHighContrast,
    onPrimary = onPrimaryDarkHighContrast,
    primaryContainer = primaryContainerDarkHighContrast,
    onPrimaryContainer = onPrimaryContainerDarkHighContrast,
    secondary = secondaryDarkHighContrast,
    onSecondary = onSecondaryDarkHighContrast,
    secondaryContainer = secondaryContainerDarkHighContrast,
    onSecondaryContainer = onSecondaryContainerDarkHighContrast,
    tertiary = tertiaryDarkHighContrast,
    onTertiary = onTertiaryDarkHighContrast,
    tertiaryContainer = tertiaryContainerDarkHighContrast,
    onTertiaryContainer = onTertiaryContainerDarkHighContrast,
    error = errorDarkHighContrast,
    onError = onErrorDarkHighContrast,
    errorContainer = errorContainerDarkHighContrast,
    onErrorContainer = onErrorContainerDarkHighContrast,
    background = backgroundDarkHighContrast,
    onBackground = onBackgroundDarkHighContrast,
    surface = surfaceDarkHighContrast,
    onSurface = onSurfaceDarkHighContrast,
    surfaceVariant = surfaceVariantDarkHighContrast,
    onSurfaceVariant = onSurfaceVariantDarkHighContrast,
    outline = outlineDarkHighContrast,
    outlineVariant = outlineVariantDarkHighContrast,
    scrim = scrimDarkHighContrast,
    inverseSurface = inverseSurfaceDarkHighContrast,
    inverseOnSurface = inverseOnSurfaceDarkHighContrast,
    inversePrimary = inversePrimaryDarkHighContrast,
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
  val colorScheme = when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
          val context = LocalContext.current
          if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }
      
      darkTheme -> darkScheme
      else -> lightScheme
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = AppTypography,
    content = content
  )
}

