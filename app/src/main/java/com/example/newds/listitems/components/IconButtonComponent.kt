package com.example.newds.listitems.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.newds.listitems.components.Component

@SuppressLint("ComposableNaming")
data class IconButtonComponent(
    override val size: Dp = 24.dp,
    val iconVariant: IconComponent.IconVariant,
    val contentDescription: String,
    val tint: Color? = null,
    val onClick: () -> Unit = { },
    val enabled: Boolean? = null,
): Component() {
    @Composable
    override fun toComposable(modifier: Modifier) {
        IconButton(
            onClick = onClick,
            enabled = enabled ?: (LocalContentColor.current.alpha == 1f),
            modifier = modifier.size(size)
        ) {
            IconComponent(
                iconVariant = iconVariant,
                contentDescription = contentDescription,
                tint = tint
            ).toComposable(modifier = Modifier)
        }
    }
}