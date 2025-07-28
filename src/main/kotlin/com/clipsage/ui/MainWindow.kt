package com.clipsage.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.window.Window
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.clipsage.core.ClipboardWatcher

@Composable
fun mainWindow(windowIsOpen: MutableState<Boolean>) = Window(onCloseRequest = {windowIsOpen.value = false },
    title = "Clipsage",
    icon = MyAppIcon,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val contents = remember { mutableStateListOf<ClipboardItem>() }
        val clipboardWatcher = ClipboardWatcher
        clipboardWatcher.startWatchingClipboard { newContent ->
            if (newContent.isNotBlank() && !contents.any { it.content == newContent }) {
                contents.add(ClipboardItem(newContent))
            }
        }
        ClipboardListView(contents)
    }
}

object MyAppIcon : Painter() {
    override val intrinsicSize = Size(256f, 256f)

    override fun DrawScope.onDraw() {
        drawOval(Color.Green, Offset(size.width / 4, 0f), Size(size.width / 2f, size.height))
        drawOval(Color.Blue, Offset(0f, size.height / 4), Size(size.width, size.height / 2f))
        drawOval(Color.Red, Offset(size.width / 4, size.height / 4), Size(size.width / 2f, size.height / 2f))
    }
}