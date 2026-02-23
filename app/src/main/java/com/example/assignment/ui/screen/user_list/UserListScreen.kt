package com.example.assignment.ui.screen.user_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.assignment.database.UserDatabase
import com.example.assignment.database.user.UserData
import com.example.assignment.ui.component.UserListComponent

@Composable
fun UserListScreen(){

    val context = LocalContext.current
    val database = UserDatabase.getDatabase(context)
    val userDao = database.userDao()
    val addressDao = database.addressDao()
    val viewmodel : UserListViewModel = viewModel(
        factory = UserListViewModelFactory(
            userDao,
            addressDao
        )
    )

    Column(

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "List Screen",
                modifier = Modifier
                    .padding(12.dp)
            )
        }
        LazyColumn(

        ) {
//            items(UserData){ data ->
//                UserListComponent(
//                    id = ,
//                    userName = ,
//                    name =
//                )
//            }
        }
    }
}
