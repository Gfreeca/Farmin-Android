package com.gfreeca.farmin_android.presentation.ui.auth.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.gfreeca.farmin_android.design_system.theme.FarminTheme

@Composable
fun FarminTextField(
    modifier: Modifier = Modifier,
    placeHolder: String = "",
    setText: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    maxLines: Int = Int.MAX_VALUE,
    onValueChange: (String) -> Unit,
) {
    FarminTheme { colors, typography ->
        Column {
            OutlinedTextField(
                modifier = modifier,
                value = setText,
                onValueChange = {
                    onValueChange(it)
                },
                keyboardOptions = keyboardOptions,
                placeholder = {
                    Text(text = placeHolder, style = typography.body2)
                },
                maxLines = maxLines,
                textStyle = typography.body2,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = colors.GRAY100,
                    placeholderColor = colors.GRAY600,
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    cursorColor = colors.BLUE500
                )
            )
        }
    }
}