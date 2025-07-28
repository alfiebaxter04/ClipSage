package com.clipsage

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.window.Tray
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberTrayState
import com.clipsage.ui.mainWindow

fun main() = application {
  val windowIsOpen = remember { mutableStateOf(false) }
  val trayState = rememberTrayState()

  Tray(
      state = trayState,
      icon = TrayIcon,
      menu = {
        Item("Open Window") { windowIsOpen.value = true }
        Item("Exit") { exitApplication() }
      })

  if (windowIsOpen.value) {
    mainWindow(windowIsOpen)
  }
}

object TrayIcon : Painter() {
  override val intrinsicSize = Size(256f, 256f)

  override fun DrawScope.onDraw() {
    drawOval(Color(0xFFFFA500))
  }
}
