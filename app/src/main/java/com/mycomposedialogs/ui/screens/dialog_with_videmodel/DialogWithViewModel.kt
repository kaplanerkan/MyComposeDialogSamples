package com.mycomposedialogs.ui.screens.dialog_with_videmodel

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mycomposedialogs.ui.theme.orange
import com.mycomposedialogs.ui.theme.white

@Composable
fun DialogWithViewModel(
    viewModel: DialogViewModel
) {
    Box(
    modifier = Modifier
    .fillMaxSize(),
    contentAlignment = Alignment.Center
    ){
        Button(
            shape = MaterialTheme.shapes.small,
            onClick = {
                viewModel.onPurchaseClick()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = orange,
                contentColor = white
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
           // shape = CircleShape
        ) {
            Text(
                text = "Confirm",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
        }
    }
    if(viewModel.isDialogShown){
        CustomDialog3(
            onDismiss = {
                viewModel.onDismissDialog()
            },
            onConfirm = {
                //viewmodel.buyItem()
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DialogWithViewModelPreview(){
    DialogWithViewModel(viewModel = DialogViewModel())

}