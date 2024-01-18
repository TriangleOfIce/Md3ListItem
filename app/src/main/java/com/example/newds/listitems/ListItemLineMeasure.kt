package com.example.newds.listitems

import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.newds.listitems.components.Component
import kotlin.math.ceil

@OptIn(ExperimentalTextApi::class)
@Composable
fun BoxWithConstraintsScope.measureTextLineCount(
    headlineText: String,
    supportingText: String?,
    leadingComponent: Component?,
    trailingComponent: Component?
): Int {
    val textMeasurer = rememberTextMeasurer()

    val totalPadding = 32
        .plus(leadingComponent?.let { 16 + it.size.value.toInt() } ?: 0)
        .plus(trailingComponent?.let { 16 + it.size.value.toInt() } ?: 0)
        .dp

    val headlineTextLineCount = textMeasurer.measure(
        text = headlineText,
        style = MaterialTheme.typography.bodyLarge,
        constraints = constraintsForTextMeasure(totalPadding)
    ).lineCount
    val supportingTextLineCount = supportingText?.let {
        textMeasurer.measure(
            text = it,
            style = MaterialTheme.typography.bodyMedium,
            constraints = constraintsForTextMeasure(totalPadding)
        ).lineCount
    } ?: 0
    return headlineTextLineCount + supportingTextLineCount
}

@Composable
fun BoxWithConstraintsScope.constraintsForTextMeasure(padding: Dp): Constraints {
    return with(LocalDensity.current) {
        constraints.copy(
            maxWidth = constraints.maxWidth - ceil(padding.toPx()).toInt()
        )
    }
}