package com.mycomposedialogs.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding

import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text

import androidx.compose.foundation.layout.size // Spacer ve size için
import androidx.compose.foundation.layout.width
import androidx.compose.material3.* // Button, Icon ve Text için
import androidx.compose.material.icons.Icons // Icon için
import androidx.compose.material.icons.filled.Favorite // Favori ikonunu kullanmak için
import androidx.compose.runtime.Composable // @Composable için
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier // Modifier için
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp // dp kullanımı için

/**
Açıklamalar:
- Row ile hizalama: fillMaxWidth() kullanarak tüm genişliği kaplıyoruz.
- Icon sola sabitlendi: İlk öğe olduğu için en solda kalıyor.
- Spacer(width = 8.dp) ile ikon ile metin arasına boşluk ekledik.
- Text bileşeni weight(1f) ile genişletildi ve sağa itildi.

Bu sayede ikon en solda, metin ise sağa yaslanmış olur.

 */
@Composable
fun ButtonWithIconSample() {
    Button(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        onClick = { /* Do something! */ },
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp) // İç padding
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = "Localized description",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.width(8.dp)) // İkon ile yazı arasına boşluk
            Text(
                "Like",
                modifier = Modifier.weight(1f), // Metni sağa itmek için
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonWithIconSamplePreview() {
    ButtonWithIconSample()
}




