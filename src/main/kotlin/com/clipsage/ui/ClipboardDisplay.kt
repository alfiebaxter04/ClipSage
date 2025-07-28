package com.clipsage.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@JvmInline value class ClipboardItem(val content: String)

@Composable
fun ClipboardItemView(item: ClipboardItem) {
  Card(
      elevation = 4.dp,
      modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp, horizontal = 8.dp)) {
        SelectionContainer {
          Text(
              text = item.content,
              modifier = Modifier.padding(12.dp),
              style = MaterialTheme.typography.body1,
          )
        }
      }
}

@Composable
fun ClipboardListView(items: List<ClipboardItem>) {
  LazyColumn(
      modifier = Modifier.fillMaxSize().padding(8.dp),
      verticalArrangement = Arrangement.spacedBy(4.dp)) {
        items(items) { item -> ClipboardItemView(item) }
      }
}
