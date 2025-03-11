package com.mycomposedialogs.ui

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowInsetsController
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.activity.viewModels
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mycomposedialogs.ui.screens.CustomDialog
import com.mycomposedialogs.ui.screens.DialogScreen
import com.mycomposedialogs.ui.screens.DialogTest
import com.mycomposedialogs.ui.screens.DialogYesNo
import com.mycomposedialogs.ui.screens.ExampleDialog
import com.mycomposedialogs.ui.screens.ResetWarning
import com.mycomposedialogs.ui.screens.dialog_with_videmodel.DialogViewModel
import com.mycomposedialogs.ui.screens.dialog_with_videmodel.DialogWithViewModel
import com.mycomposedialogs.ui.theme.MyappTheme
import com.mycomposedialogs.ui.theme.orange

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<DialogViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        // DEPRECATED
        this.window.navigationBarColor = orange.toArgb()
        this.window.statusBarColor = orange.toArgb()

        super.onCreate(savedInstanceState)


        // Set the navigation and status bar colors
        //setWindowColors(window, Color(0xFFDB660D)) // Use your desired color here


        enableEdgeToEdge()
        setContent {
            MyappTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   // Greeting( modifier = Modifier.padding(innerPadding))
                    DialogWithViewModel(viewModel)

                }
            }
        }
    }
}





// Function to set navigation and status bar colors
private fun setWindowColors(window: Window, color: Color) {
    window.navigationBarColor = color.toArgb()
    window.statusBarColor = color.toArgb()

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        window.insetsController?.setSystemBarsAppearance(
            WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
            WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
        )
        window.insetsController?.setSystemBarsAppearance(
            WindowInsetsController.APPEARANCE_LIGHT_NAVIGATION_BARS,
            WindowInsetsController.APPEARANCE_LIGHT_NAVIGATION_BARS
        )
    } else {
        @Suppress("DEPRECATION")
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        @Suppress("DEPRECATION")
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
    }
}







@Composable
fun Greeting(modifier: Modifier) {
    //var showDialog by remember { mutableStateOf(false) } // ✅ Manage dialog visibility state
    var showDialog by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { showDialog = true }) {
            Text("Dialogu Aç")
        }
    }

    if (showDialog) {
/*        DialogScreen(
            onResult = { isConfirmed ->
                showDialog = false
                if (isConfirmed) {
                    println("Kullanıcı EVET dedi.")
                } else {
                    println("Kullanıcı HAYIR dedi.")
                }
            }
        )*/

        /*  CALISLIYOR
       ExampleDialog(
           onDismiss = { showDialog = false },
           onConfirm = { showDialog = false }
       )
*/




        /*
        CALISIYOR
        var showDialog by remember {
            mutableStateOf(false)
        }

        CustomDialog(
            showDialog = showDialog,
            onDismissRequest = { showDialog = false }
        ) {
            ResetWarning(
                onDismissRequest = { showDialog = false }
            )
        }

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Button(onClick = {
                showDialog = true
            }) {
                Text(text = "Reset")
            }

        }
*/



/* OK CALISIYOR  */
//    DialogTest()



    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyappTheme {
        Greeting(modifier = Modifier.padding(8.dp))
    }
}

