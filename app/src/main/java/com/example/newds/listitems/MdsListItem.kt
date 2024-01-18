package com.example.newds.listitems

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.newds.listitems.components.Component

// WIP for lambda providing
@Composable
fun MdsListItem(
    modifier: Modifier = Modifier,
    settings: ListItemSettings
) {
    ListItemBase(
        settings.headlineText,
        settings.supportingText,
        settings.onClick,
        settings.clickEnabled,
        settings.enabled,
        settings.selected,
        settings.leadingComponent,
        settings.trailingComponent
    )
}

@Composable
fun ListItemBase(
    headlineText: String,
    supportingText: String?,
    onClick: () -> Unit,
    clickEnabled: Boolean,
    enabled: Boolean,
    selected: Boolean,
    leadingComponent: Component?,
    trailingComponent: Component?
) {
    CompositionLocalProvider(
        LocalContentColor provides LocalContentColor.current.copy(
            alpha = if (enabled) 1f else 0.5f
        )
    ) {
        BoxWithConstraints {
            val lineCount = measureTextLineCount(
                headlineText = headlineText,
                supportingText = supportingText,
                leadingComponent = leadingComponent,
                trailingComponent = trailingComponent
            )
            val verticalAlignment = if (lineCount > 2)
                Alignment.Top
            else
                Alignment.CenterVertically
            val minHeightByLineCount = when (lineCount) {
                1 -> 40.dp
                2 -> 56.dp
                else -> 72.dp
            }

            ListItemContent(
                headlineText = headlineText,
                supportingText = supportingText,
                onClick = onClick,
                clickEnabled = clickEnabled,
                enabled = enabled,
                selected = selected,
                leadingComponent = leadingComponent,
                trailingComponent = trailingComponent,
                verticalAlignment = verticalAlignment,
                minHeightByLineCount = minHeightByLineCount,
                modifier = Modifier
            )
        }
    }
}

@Composable
private fun ListItemContent(
    verticalAlignment: Alignment.Vertical,
    minHeightByLineCount: Dp,
    headlineText: String,
    supportingText: String?,
    onClick: () -> Unit,
    clickEnabled: Boolean,
    selected: Boolean,
    enabled: Boolean,
    leadingComponent: Component?,
    trailingComponent: Component?,
    modifier: Modifier = Modifier
) {
    val backgroundModifier = if (selected) Modifier.background(
        color = MaterialTheme.colorScheme.primaryContainer,
        shape = RoundedCornerShape(8.dp)
    ) else Modifier
    Row(
        verticalAlignment = verticalAlignment,
        modifier = modifier
            .clickable(
                enabled = clickEnabled && enabled,
                onClick = onClick,
            )
            .then(backgroundModifier)
            .padding(vertical = 8.dp)
            .defaultMinSize(minHeight = minHeightByLineCount)
    ) {
        leadingComponent?.toComposable(
            modifier = Modifier.padding(start = 16.dp)
        )
        TextContent(
            headlineText = headlineText,
            supportingText = supportingText,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .weight(1f),
        )
        trailingComponent?.toComposable(
            modifier = Modifier.padding(end = 16.dp)
        )
    }
}

@Composable
fun TextContent(
    modifier: Modifier = Modifier,
    headlineText: String,
    supportingText: String?,
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = headlineText,
            style = MaterialTheme.typography.bodyLarge
        )
        supportingText?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
