package com.example.newds.listitems.preview

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.newds.listitems.ListItemSettings
import com.example.newds.listitems.MdsListItem

@Preview
@Composable
fun TextContentPreview() {
    MaterialTheme(colorScheme = if (isSystemInDarkTheme()) darkColorScheme() else lightColorScheme()) {
        Surface {
            Column {
                MdsListItem(
                    settings = ListItemSettings(
                        headlineText = "One line list item"
                    )
                )
                MdsListItem(
                    settings = ListItemSettings(
                        headlineText = "One line list item",
                        supportingText = "Supporting text"
                    )
                )
            }
        }
    }
}