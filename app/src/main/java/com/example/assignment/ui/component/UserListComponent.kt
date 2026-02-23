package com.example.assignment.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun UserListComponent(
    id: String ,
    userName : String,
    name : String
){
    Row(
        modifier = Modifier.clickable(
            onClick = {}
        )
    ) {
        Column(

        ) {
            Text(
                text = id
            )
            Text(
                text = userName
            )
            Text(
                text = name
            )
        }
    }
}