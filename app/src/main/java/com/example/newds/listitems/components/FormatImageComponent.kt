package com.example.newds.listitems.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathOperation
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.newds.listitems.components.Component

@SuppressLint("ComposableNaming")
class FormatImageComponent(
    override val size: Dp = 24.dp,
    val primaryPainter: Painter,
    val accessIconVariant: IconComponent.IconVariant? = null,
    val secondaryTint: Color? = null,
    val primaryContentDescription: String,
    val secondaryContentDescription: String,
): Component() {
    @Composable
    override fun toComposable(modifier: Modifier) {
        Box(
            modifier = modifier.size(size),
        ) {
            Image(
                painter = primaryPainter,
                contentDescription = primaryContentDescription,
                alpha = LocalContentColor.current.alpha,
                modifier = Modifier.clip(
                    if (accessIconVariant != null)
                        CircleCutoutShape(DpOffset(16.dp, 12.dp), DpSize(16.dp, 16.dp))
                    else
                        RectangleShape
                )
            )

            if (accessIconVariant != null) {
                IconComponent(
                    size = 16.dp,
                    iconVariant = accessIconVariant,
                    contentDescription = secondaryContentDescription,
                    tint = secondaryTint
                ).toComposable(
                    modifier = Modifier
                        .offset(x = 8.dp, y = 4.dp)
                        .align(Alignment.BottomEnd)
                )
            }
        }
    }
}

@Immutable
internal class CircleCutoutShape(
    private val cutoutOffset: DpOffset,
    private val cutoutSize: DpSize,
) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density,
    ): Outline {
        val cutoutRect = with(density) {
            Rect(
                Offset(cutoutOffset.x.toPx(), cutoutOffset.y.toPx()),
                Size(cutoutSize.height.toPx(), cutoutSize.width.toPx()),
            )
        }

        val cutoutPath = Path().apply {
            addOval(cutoutRect)
        }

        val mainPath = Path().apply {
            addRect(Rect(Offset.Zero, size))
        }

        return Outline.Generic(Path.combine(PathOperation.Difference, mainPath, cutoutPath))
    }
}