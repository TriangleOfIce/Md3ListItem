package com.example.newds.listitems.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@SuppressLint("ComposableNaming")
data class RadioButtonComponent(
    val selected: Boolean,
    val enabled: Boolean? = null,
    val onClick: (() -> Unit)? = null
): Component() {
    override val size: Dp = 24.dp

    @Composable
    override fun toComposable(modifier: Modifier) {
        RadioButton(
            selected = selected,
            onClick = onClick,
            modifier = modifier.size(size),
            enabled = enabled ?: (LocalContentColor.current.alpha == 1f)
        )
    }
}