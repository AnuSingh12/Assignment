package com.example.assignment.ui.screen.homeScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(onUserList: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = " Home Screen"
            )
        }

        Button(
            onClick = {
                onUserList()
            }
        ) {
            Text(
                text = "UserList"
            )
        }
        Button(
            onClick = {
//                onImage()
            }
        ) {
            Text(
                text = "ImageScreen"
            )
        }

    }
}
