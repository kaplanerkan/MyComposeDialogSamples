package com.mycomposedialogs.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog

class ColumnRowDialog {
}

data class DialogEvent(
    val type: DialogType,
    val message: String
)

enum class DialogType {
    RowType, ColumnType
}

@Composable
private fun ColumnDialog(
    text: String,
    onDismissRequest: () -> Unit
) {

    Dialog(onDismissRequest = onDismissRequest) {
        Row(Modifier.background(Color.Green)) {
            Text(text = text)
            Text(text = text)
        }
    }
}

@Composable
private fun RowDialog(
    text: String,
    onDismissRequest: () -> Unit
) {

    Dialog(onDismissRequest = onDismissRequest) {
        Row(Modifier.background(Color.Red)) {
            Text(text = text)
            Text(text = text)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DialogTest() {
    var dialogEvent by remember {
        mutableStateOf<DialogEvent?>(value = null)
    }

    dialogEvent?.let { event ->
        when (event.type) {
            DialogType.RowType -> {
                RowDialog(text = event.message) {
                    dialogEvent = null
                }
            }

            DialogType.ColumnType -> {
                ColumnDialog(text = event.message) {
                    dialogEvent = null
                }
            }
        }
    }

    Column {
        Button(onClick = {
            dialogEvent = DialogEvent(DialogType.ColumnType, "Column Dialog")
        }
        ) {
            Text(text = "Column Dialog")
        }

        Button(onClick = {
            dialogEvent = DialogEvent(DialogType.RowType, "Row Dialog")

        }
        ) {
            Text(text = "Row Dialog")
        }
    }
}