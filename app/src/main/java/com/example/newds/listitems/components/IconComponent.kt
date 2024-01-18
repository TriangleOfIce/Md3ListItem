package com.example.newds.listitems.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@SuppressLint("ComposableNaming")
data class IconComponent(
    override val size: Dp = 24.dp,
    val iconVariant: IconVariant,
    val contentDescription: String,
    val tint: Color? = null,
): Component() {
    @Composable
    override fun toComposable(modifier: Modifier) {
        Icon(
            imageVector = iconVariant.imageVector,
            contentDescription = contentDescription,
            tint = (tint ?: MaterialTheme.colorScheme.outline)
                .copy(alpha = LocalContentColor.current.alpha),
            modifier = modifier.size(size)
        )
    }

    enum class IconVariant(val imageVector: ImageVector) {
        Checkmark(Icons.Rounded.CheckCircle),
        Check(Icons.Rounded.Check),
        MoreVert(Icons.Rounded.MoreVert),
        Info(Icons.Rounded.Info)
    }
}