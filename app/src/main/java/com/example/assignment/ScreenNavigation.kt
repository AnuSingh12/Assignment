package com.example.assignment

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.example.assignment.database.UserDatabase
import com.example.assignment.ui.navigation.HomeKey
import com.example.assignment.ui.navigation.UserDetailsKey
import com.example.assignment.ui.navigation.UserListKey
import com.example.assignment.ui.screen.homeScreen.HomeScreen
import com.example.assignment.ui.screen.user_details.UserDetailsScreen
import com.example.assignment.ui.screen.user_list.UserListScreen

@Composable
fun Navigation() {
    val context = LocalContext.current
    val database = UserDatabase.getDatabase(context)
    val userDao = database.userDao()
    val addressDao = database.addressDao()

    val viewmodel: MainViewModel = viewModel(
        factory = MainViewModelFactory(
            userDao,
            addressDao
        )
    )


    val backStack = remember { mutableStateListOf<Any>(HomeKey) }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                is HomeKey -> NavEntry(key) {
                    HomeScreen(
//                        onImage = {
//                            backStack.add(UserDetailsKey())
//                        },
                        onUserList = {
                            backStack.add(UserListKey)
                        },
                    )

                }

                is UserDetailsKey -> NavEntry(key) {
                    UserDetailsScreen()
                }

                is UserListKey -> NavEntry(key) {
                    UserListScreen(
                        navigateUserData = { id ->
                            backStack.add(UserDetailsKey(id = id))
                        }
                    )
                }

                else -> NavEntry(Unit) { Text("Unknown") }
            }
        }
    )
}

