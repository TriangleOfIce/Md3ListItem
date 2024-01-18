package com.example.newds.listitems.preview

import android.content.res.Configuration
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newds.R
import com.example.newds.listitems.ListItemSettings
import com.example.newds.listitems.MdsListItem
import com.example.newds.listitems.components.FormatImageComponent
import com.example.newds.listitems.components.IconButtonComponent
import com.example.newds.listitems.components.IconComponent

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun FileContentPreview() {
    MaterialTheme(colorScheme = if (isSystemInDarkTheme()) darkColorScheme() else lightColorScheme()) {
        Surface {
            Column(modifier = Modifier.padding(8.dp)) {
                MdsListItem(
                    settings = ListItemSettings(
                        enabled = false,
                        headlineText = "One line list item",
                        leadingComponent = FormatImageComponent(
                            primaryPainter = painterResource(R.drawable.format_word),
                            primaryContentDescription = "Localized description",
                            secondaryContentDescription = "Localized description"
                        ),
                        trailingComponent = IconButtonComponent(
                            iconVariant = IconComponent.IconVariant.MoreVert,
                            contentDescription = "Localized description",
                            enabled = false,
                        ),
                        onClick = { },
                        clickEnabled = true
                    )
                )
                MdsListItem(
                    settings = ListItemSettings(
                        headlineText = "Two line list item",
                        supportingText = "Supporting text",
                        leadingComponent = FormatImageComponent(
                            primaryPainter = painterResource(R.drawable.format_word),
                            accessIconVariant = IconComponent.IconVariant.Info,
                            primaryContentDescription = "Localized description",
                            secondaryContentDescription = "Localized description"
                        ),
                        trailingComponent = IconButtonComponent(
                            iconVariant = IconComponent.IconVariant.MoreVert,
                            contentDescription = "Localized description",
                        ),
                    )
                )
                MdsListItem(
                    settings = ListItemSettings(
                        headlineText = "Two line list item",
                        supportingText = "Supporting text",
                        leadingComponent = FormatImageComponent(
                            primaryPainter = painterResource(R.drawable.format_word),
                            accessIconVariant = IconComponent.IconVariant.Info,
                            primaryContentDescription = "Localized description",
                            secondaryContentDescription = "Localized description"
                        ),
                        trailingComponent = IconButtonComponent(
                            iconVariant = IconComponent.IconVariant.MoreVert,
                            contentDescription = "Localized description",
                        ),
                        selected = true
                    )
                )
                MdsListItem(
                    settings = ListItemSettings(
                        headlineText = "Three line list item",
                        supportingText = "Secondary text that is long and perhaps goes onto another line",
                        leadingComponent = FormatImageComponent(
                            primaryPainter = painterResource(R.drawable.format_word),
                            accessIconVariant = IconComponent.IconVariant.Info,
                            primaryContentDescription = "Localized description",
                            secondaryContentDescription = "Localized description"
                        ),
                        trailingComponent = IconButtonComponent(
                            iconVariant = IconComponent.IconVariant.MoreVert,
                            contentDescription = "Localized description",
                        )
                    )
                )
                MdsListItem(
                    settings = ListItemSettings(
                        headlineText = "Three line list item",
                        supportingText = "Secondary text that is long and perhaps goes onto another line",
                        leadingComponent = FormatImageComponent(
                            primaryPainter = painterResource(R.drawable.format_word),
                            accessIconVariant = IconComponent.IconVariant.Info,
                            primaryContentDescription = "Localized description",
                            secondaryContentDescription = "Localized description"
                        ),
                        trailingComponent = IconButtonComponent(
                            iconVariant = IconComponent.IconVariant.MoreVert,
                            contentDescription = "Localized description",
                        ),
                        selected = true
                    )
                )
            }
        }
    }
}