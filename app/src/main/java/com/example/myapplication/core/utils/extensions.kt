package com.example.myapplication.core.utils

import android.content.res.Resources
import androidx.annotation.DimenRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

@Composable
@ReadOnlyComposable
fun fontDimensionResource(@DimenRes id: Int) = dimensionResource(id = id).value.sp

@Composable
@ReadOnlyComposable
fun Modifier.focusHighlight() = composed {
    this.onFocusChanged {
        if (it.hasFocus) {
            drawWithContent {
                drawRect(size = size, color = Color.White, alpha = 0.4f)
            }
        }
    }
}