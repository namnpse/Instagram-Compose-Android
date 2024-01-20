package com.namnp.instagram_android.presentation.login.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.namnp.instagram_android.presentation.ui.theme.Blue200
import com.namnp.instagram_android.presentation.ui.theme.textFieldColor

@Composable
fun InputAccount(
    username: String = "",
    password: String = "",
    onUsernameChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    showPassword: Boolean = false,
    onToggleShowPassword: () -> Unit,
) {
    var isPasswordFocus: Boolean by remember { mutableStateOf(false) }
    var isUsernameFocus: Boolean by remember { mutableStateOf(false) }
    Column {
        TextField(
            value = username,
            onValueChange = onUsernameChanged,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp, horizontal = 16.dp)
                .border(
                    width = 1.dp,
                    color = if (isUsernameFocus) Blue200 else Color(0x1A000000),
                    shape = RoundedCornerShape(8.dp),
                )
                .onFocusChanged {
                    isUsernameFocus = it.hasFocus
                },
            colors = textFieldColor,
            label = {
                Text(text = "Username")
            },
            /*         trailingIcon = {
                         Icon(Icons.Filled.AccountCircle, "", tint = Blue200)
                     },*/
        )
        TextField(
            value = password,
            onValueChange = onPasswordChanged,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp, horizontal = 16.dp)
                .border(
                    width = 1.dp,
                    color = if (isPasswordFocus) Blue200 else Color(0x1A000000),
                    shape = RoundedCornerShape(8.dp),
                )
                .onFocusChanged {
                    isPasswordFocus = it.hasFocus
                },
            colors = textFieldColor,
            label = {
                Text(text = "Password")
            },
            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val image = if (showPassword)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff
                val description = if (showPassword) "Hide password" else "Show password"
                IconButton(onClick = onToggleShowPassword) {
                    Icon(imageVector = image, description)
                }
            }
        )
    }
}