package com.mycomposedialogs.ui.screens


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun CustomDialog(
    showDialog: Boolean,
    onDismissRequest: () -> Unit,
    content: @Composable () -> Unit,
) {
    if (showDialog) {
        Dialog(
            onDismissRequest = onDismissRequest,
            properties = DialogProperties(
                usePlatformDefaultWidth = false
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .pointerInput(Unit) { detectTapGestures { } },
                contentAlignment = Alignment.Center
            ) {
                Box(
                    Modifier
                        .shadow(8.dp, shape = RoundedCornerShape(16.dp))
                        .width(300.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(
                            MaterialTheme.colorScheme.surface,
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    content()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CustomDialogPreview() {
    CustomDialog(showDialog = true, onDismissRequest = { /*TODO*/ }) {

    }

}


/*
Dialog'un ekranın tam ortasında görünmesini sağlamak için Box
bileşenini Modifier.fillMaxSize() ile kullanarak ekranın tamamını kaplamasını
 ve contentAlignment parametresiyle içeriğin merkezde yer almasını
 sağlayacağız.

 */
@Composable
fun ExampleDialog(onDismiss: () -> Unit, onConfirm: () -> Unit) {


    CustomDialog(
        showDialog = true,
        onDismissRequest = { },
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Başlık",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Bu bir gövde metnidir. Buraya istediğiniz içeriği ekleyebilirsiniz.",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = {
                        Log.e("SONUC", "Hayir Tiklandi")
                        onDismiss()
                    }
                ) {
                    Text("HAYIR")
                }

                Button(
                    onClick = {
                        Log.e("SONUC", "Evet Tiklandi")
                        onConfirm()
                    }
                ) {
                    Text("EVET")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExampleDialogPreview() {
    ExampleDialog(onDismiss = {}, onConfirm = {})
}

