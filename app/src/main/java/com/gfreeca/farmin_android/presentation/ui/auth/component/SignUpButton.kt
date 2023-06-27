package com.gfreeca.farmin_android.presentation.ui.auth.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.gfreeca.farmin_android.design_system.theme.FarminTheme

@Composable
fun SignUpButton(onClick: () -> Unit) {
    FarminTheme { colors, typography ->
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = colors.BLUE500)
        ) {
            Text(
                text = "시작하기",
                style = typography.subtitle,
                fontWeight = FontWeight.Bold,
                color = colors.WHITE,
                modifier = Modifier.padding(vertical = 3.dp)
            )
        }
    }
}