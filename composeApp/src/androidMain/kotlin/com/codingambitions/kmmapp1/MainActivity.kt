package com.codingambitions.kmmapp1

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.rememberAsyncImagePainter
import data.RandomUser

class MainActivity : ComponentActivity() {

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val users = homeViewModel.users.collectAsStateWithLifecycle()
            AndroidApp(users = users.value)

        }
    }
}

@Composable
fun AndroidApp(users: List<RandomUser>) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(users, key = { user -> user.login?.uuid.toString() }) { user ->
            Card(
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                elevation = 2.dp
            ) {

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = rememberAsyncImagePainter(model = user.picture?.thumbnail),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(16.dp)
                            .size(50.dp)
                    )
                    Column(verticalArrangement = Arrangement.Center) {
                        Text(text = "${user.name?.first} ${user.name?.last}")
                        Text(text = user.phone.toString())
                    }
                }

            }
        }

    }
}