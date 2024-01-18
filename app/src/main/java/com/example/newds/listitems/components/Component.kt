package com.example.newds.listitems.components

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@SuppressLint("ComposableNaming")
sealed class Component {
    abstract val size: Dp

    @Composable
    abstract fun toComposable(modifier: Modifier)
}