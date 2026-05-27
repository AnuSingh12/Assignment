package com.example.assignment.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun UserListComponent(
    id: String ,
    userName : String,
    name : String,
    onNavigate:() -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .clickable(
            onClick = {
                onNavigate()
            },
        )
    ) {
        Column(
        ) {
            Text(
                text = userName
            )
            Text(
                text = name
            )
        }
    }
}