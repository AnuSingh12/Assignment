package com.example.assignment.ui.screen.user_list

import android.R.attr.onClick
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.assignment.database.UserDatabase
import com.example.assignment.ui.component.UserListComponent

@Composable
fun UserListScreen(
    navigateUserData: (String) -> Unit
) {

    val context = LocalContext.current
    val database = UserDatabase.getDatabase(context)
    val userDao = database.userDao()
    val addressDao = database.addressDao()
    val viewmodel: UserListViewModel = viewModel(
        factory = UserListViewModelFactory(
            userDao,
            addressDao
        )
    )
    val userData by viewmodel.userData.collectAsState()

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
        Row(

        ) {
            Switch(
                checked = true,
                onCheckedChange = {}
            )
            Button(
                onClick = {

                }
            ) {

            }
        }
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(userData) { data ->
                UserListComponent(
                    id = data.id,
                    userName = data.userName,
                    name = data.name,
                    checked = true,
                    onChecked = {

                    },
                    onNavigate = {navigateUserData(data.id)}
                )
            }
        }

        Button(
            onClick = {

            }
        ) {

        }
    }
}
