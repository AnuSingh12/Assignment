package com.example.assignment.ui.screen.user_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.assignment.database.UserDatabase

@Composable
fun UserDetailsScreen(
    id: String
) {

    val context = LocalContext.current
    val database = UserDatabase.getDatabase(context)

    val userDao = database.userDao()
    val addressDao = database.addressDao()
    val companyDao = database.companyDao()

    val viewModel: UserDetailsViewModel =
        viewModel(
            factory = UserDetailsViewModelFActory(
                userDao, addressDao, companyDao
            )
        )

    val userData by viewModel.singleUserData.collectAsState()

    val addressData by viewModel.addressData.collectAsState()

    val companyData by viewModel.companyData.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.readData(id)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            text = "User Details",
            style = MaterialTheme.typography.headlineMedium
        )

        userData?.let { user ->

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "User Info",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text("Name: ${user.name}")
                    Text("Username: ${user.userName}")
                    Text("Email: ${user.email}")
                    Text("Phone: ${user.phone}")
                    Text("Website: ${user.webSite}")
                }
            }
        }

        addressData?.let { address ->

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Address",
                        style = MaterialTheme.typography.titleLarge
                    )

                    Text(
                        "Street: ${address.street}"
                    )

                    Text(
                        "City: ${address.city}"
                    )

                    Text(
                        "Zip Code: ${address.zipCode}"
                    )
                }
            }
        }

        companyData?.let { company ->

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Company",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        "Name: ${company.name}"
                    )
                    Text(
                        "Catch Phrase: ${company.catchPhrase}"
                    )
                    Text(
                        "BS: ${company.bs}"
                    )
                }
            }
        }
    }
}