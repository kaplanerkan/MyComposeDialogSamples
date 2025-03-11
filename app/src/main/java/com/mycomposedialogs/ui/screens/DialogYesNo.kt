package com.mycomposedialogs.ui.screens

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.composables.core.Dialog
import com.composables.core.DialogPanel
import com.composables.core.Scrim
import com.composables.core.rememberDialogState
import kotlinx.coroutines.delay


@Composable
fun DialogYesNo(onDismiss: () -> Unit, onConfirm: () -> Unit) {
    /**
     * Add the following dependency to your build.gradle.kts:
     *
     * dependencies {
     *      implementation("com.composables:core:1.11.2")
     * }
     */

    val state = rememberDialogState(visible = true)

    LaunchedEffect(state.visible) {
        if (state.visible.not()) {
            delay(1000)
            state.visible = true
        }
    }
    BoxWithConstraints {
        val isCompact = maxWidth <= 600.dp

        Dialog(state) {
            Scrim(enter = fadeIn(), exit = fadeOut(), scrimColor = Color.Black.copy(0.3f))
            DialogPanel(
                modifier = Modifier
                    .systemBarsPadding()
                    .padding(16.dp)
                    .shadow(8.dp, MaterialTheme.shapes.large)
                    .background(Color.White, MaterialTheme.shapes.medium)
                    .padding(24.dp),
                enter = scaleIn(initialScale = 0.8f) + fadeIn(tween(durationMillis = 250)),
                exit = scaleOut(targetScale = 0.6f) + fadeOut(tween(durationMillis = 150))
            ) {
                Column(
                    modifier = Modifier.let {
                        if (isCompact) it.fillMaxWidth() else it.widthIn(min = 280.dp, max = 520.dp)
                    },
                    horizontalAlignment = if (isCompact) Alignment.CenterHorizontally else Alignment.Start
                ) {
                    BasicText(
                        text = "Are you sure?",
                        style = TextStyle.Default

                    )
                    Spacer(Modifier.height(16.dp))
                    BasicText(
                        text = "This action cannot be undone. Choose wisely.",
                        style = TextStyle.Default
                    )
                    Spacer(Modifier.height(24.dp))
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(
                            8.dp,
                            alignment = Alignment.End
                        ),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Box(
                            Modifier
                                .clip(MaterialTheme.shapes.large)
                                .clickable(role = Role.Button) {
                                    state.visible = false
                                    onDismiss()
                                }

                                .border(1.dp, Color(0xFFBDBDBD), MaterialTheme.shapes.medium)
                                .padding(horizontal = 14.dp, vertical = 10.dp)
                                .let { if (isCompact) it.weight(1f) else it },
                            contentAlignment = Alignment.Center
                        ) {
                            BasicText(
                                text = "Cancel", style = TextStyle.Default
                            )

                        }
                        Box(
                            Modifier
                                .clip(MaterialTheme.shapes.small)
                                .clickable(role = Role.Button) {
                                    state.visible = false
                                    onConfirm()
                                }
                                .background(Color(0xFF212121))
                                .padding(horizontal = 14.dp, vertical = 10.dp)
                                .let { if (isCompact) it.weight(1f) else it },
                            contentAlignment = Alignment.Center
                        ) {
                            BasicText(
                                text = "Continue",
                                style = TextStyle.Default.copy(color = Color.White)

                            )
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DialogYesNoPreview() {
    DialogYesNo(onDismiss = {}, onConfirm = {})
}

