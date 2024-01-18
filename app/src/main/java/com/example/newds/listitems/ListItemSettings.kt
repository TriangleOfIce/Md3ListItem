package com.example.newds.listitems

import com.example.newds.listitems.components.Component

data class ListItemSettings(
    val headlineText: String,
    val supportingText: String? = null,
    val leadingComponent: Component? = null,
    val trailingComponent: Component? = null,
    val onClick: () -> Unit = { },
    val clickEnabled: Boolean = false,
    val enabled: Boolean = true,
    val selected: Boolean = false
)