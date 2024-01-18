package com.example.newds.listitems.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@SuppressLint("ComposableNaming")
data class CheckboxComponent(
    val checked: Boolean,
    val enabled: Boolean? = null,
    val onCheckedChange: ((Boolean) -> Unit)? = null
): Component() {
    override val size: Dp = 24.dp

    @Composable
    override fun toComposable(modifier: Modifier) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            modifier = modifier.size(size),
            enabled = enabled ?: (LocalContentColor.current.alpha == 1f)
        )
    }
}