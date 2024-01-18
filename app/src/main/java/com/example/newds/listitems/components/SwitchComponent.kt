package com.example.newds.listitems.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.height
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@SuppressLint("ComposableNaming")
data class SwitchComponent(
    val checked: Boolean,
    val enabled: Boolean? = null,
    val onCheckedChange: ((Boolean) -> Unit)? = null
): Component() {
    override val size: Dp = 52.dp

    @Composable
    override fun toComposable(modifier: Modifier) {
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            modifier = modifier.height(32.dp),
            enabled = enabled ?: (LocalContentColor.current.alpha == 1f)
        )
    }
}