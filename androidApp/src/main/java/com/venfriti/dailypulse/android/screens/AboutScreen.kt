package com.venfriti.dailypulse.android.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.venfriti.dailypulse.Platform


@Composable
fun AboutScreen(

) {
    Column {
        Toolbar()
        ContentView()

    }
}


@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun Toolbar(
) {
    TopAppBar(
        title = { Text(text = "About Device")}
    )
}

@Composable
private fun ContentView() {
    val items = makeItems()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        items(items) { row ->
            RowView(title = row.first, subtitle = row.second)
        }
    }
}

fun makeItems(): List<Pair<String, String>> {
    return listOf(
        "OS Name" to Platform().osName,
        "OS Version" to Platform().osVersion,
        "Device Model" to Platform().deviceModel,
        "Density" to Platform().density.toString()
    )
}

@Composable
fun RowView(
    title: String,
    subtitle: String
) {
    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodyLarge
        )
    }
    Divider()
}
