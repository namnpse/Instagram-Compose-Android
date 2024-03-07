package com.namnp.instagram_android.presentation.common

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.namnp.instagram_android.domain.model.User

typealias VoidCallback = () -> Unit
typealias ValueCallback<T> = (value: T) -> Unit

@Composable
fun TypeAliasComposable() {
    val context = LocalContext.current
    val users = arrayListOf("Namnpse", "Bryan")
    Column {
        LoginPage {
            // onLoginComplete
            Toast.makeText(context, "Login successfully", Toast.LENGTH_LONG).show()
        }
        UserListPage(users = users) { user ->
            // navigate to detailed user screen
        }
    }
}

@Composable
fun LoginPage(
    onLoginComplete: VoidCallback
) {

}

@Composable
fun UserListPage(
    users: ArrayList<String>,
    onItemClicked: ValueCallback<User>
) {

}