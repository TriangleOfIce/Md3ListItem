package com.example.newds.listitems.preview

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.newds.listitems.ListItemSettings
import com.example.newds.listitems.MdsListItem
import com.example.newds.listitems.components.CheckboxComponent
import com.example.newds.listitems.components.IconComponent
import com.example.newds.listitems.components.SwitchComponent

@Preview
@Composable
fun LeadingContentPreview() {
    MaterialTheme(colorScheme = if (isSystemInDarkTheme()) darkColorScheme() else lightColorScheme()) {
        Surface {
            var iconVariant by remember { mutableStateOf(IconComponent.IconVariant.Checkmark) }

            Column {
                MdsListItem(
                    settings = ListItemSettings(
                        headlineText = "One line list item",
                        leadingComponent = IconComponent(
                            iconVariant = iconVariant,
                            contentDescription = "Localized description",
                        ),
                        onClick = {
                            iconVariant = when (iconVariant) {
                                IconComponent.IconVariant.Checkmark -> IconComponent.IconVariant.Check
                                IconComponent.IconVariant.Check -> IconComponent.IconVariant.Checkmark
                                IconComponent.IconVariant.MoreVert -> IconComponent.IconVariant.MoreVert
                                else -> IconComponent.IconVariant.Info
                            }
                        },
                        clickEnabled = true
                    )
                )
                var checked by remember { mutableStateOf(false) }
                MdsListItem(
                    settings = ListItemSettings(
                        headlineText = "Two line list item",
                        supportingText = "Supporting text",
                        leadingComponent = IconComponent(
                            iconVariant = IconComponent.IconVariant.Check,
                            contentDescription = "Localized description",
                        ),
                        trailingComponent = CheckboxComponent(
                            checked = checked,
                            onCheckedChange = { checked = !checked }
                        )
                    )
                )
                var checked2 by remember { mutableStateOf(false) }
                MdsListItem(
                    settings = ListItemSettings(
                        enabled = false,
                        headlineText = "Three line list item",
                        supportingText = "Secondary text that is long and perhaps goes onto another line",
                        leadingComponent = IconComponent(
                            iconVariant = IconComponent.IconVariant.Check,
                            contentDescription = "Localized description",
                        ),
                        trailingComponent = SwitchComponent(
                            checked = checked2,
                            enabled = false,
                            onCheckedChange = { checked2 = !checked2 }
                        ),
                        onClick = { },
                        clickEnabled = true
                    )
                )
            }
        }
    }
}