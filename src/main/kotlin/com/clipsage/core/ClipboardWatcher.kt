package com.clipsage.core

import java.awt.Toolkit
import java.awt.datatransfer.DataFlavor
import kotlin.concurrent.thread

object ClipboardWatcher {
  var clipboardContent: String = ""

  fun startWatchingClipboard(onChange: (String) -> Unit) {
    thread {
      while (true) {
        val currentContent =
            Toolkit.getDefaultToolkit().systemClipboard.getData(DataFlavor.stringFlavor) as String

        if (currentContent != clipboardContent) {
          clipboardContent = currentContent
          onChange(currentContent)
        }

        Thread.sleep(1000)
      }
    }
  }
}
