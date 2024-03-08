package com.arkan.aresto.model

import androidx.annotation.DrawableRes
import java.util.UUID

data class Category(
    val id: String = UUID.randomUUID().toString(),
    @DrawableRes
    var image: Int,
    var name: String
)
