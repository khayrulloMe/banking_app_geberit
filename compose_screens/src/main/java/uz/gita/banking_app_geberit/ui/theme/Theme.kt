package uz.gita.banking_app_geberit.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)
private val TertiaryColorScheme = lightColorScheme(
    primary = Green10,
    secondary = Green40,
    tertiary = Green90,
    background = Green80,
    onBackground = Green90,
    onPrimary = Green90

)
private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
)



object ApplicationTheme {
    var theme = mutableStateOf(Theme.LITE)
}

object ApplicationTypography {
    var typography = mutableStateOf(TYPOGRAPHY.MEDIUM)
}

@Composable
fun AppTheme(
    theme: Theme = ApplicationTheme.theme.value,
    typography: TYPOGRAPHY = ApplicationTypography.typography.value,
    content: @Composable () -> Unit
) {
    val colorScheme = when (theme) {
        Theme.LITE -> {
            LightColorScheme
        }
        Theme.DARK -> {
            DarkColorScheme
        }
        Theme.TERTIARY -> {
            TertiaryColorScheme
        }
    }
    val usingTypography: Typography = when (typography) {
        TYPOGRAPHY.LARGE -> {
            Large
        }
        TYPOGRAPHY.MEDIUM -> {
            Medium
        }
        TYPOGRAPHY.SMALL -> {
            Small
        }
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = when (theme) {
                Theme.LITE -> {
                    false
                }
                Theme.DARK -> {
                    true
                }
                Theme.TERTIARY -> {
                    false
                }
            }
        }
    }

    MaterialTheme(
        colorScheme = colorScheme, typography = usingTypography, content = content
    )
}

enum class Theme {
    LITE, DARK, TERTIARY
}

enum class TYPOGRAPHY {
    LARGE, MEDIUM, SMALL
}