package com.example.marvel.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import coil.compose.AsyncImage
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

@Composable
fun HeroScreen(navController: NavController, navBackStackEntry: NavBackStackEntry) {
    val heroName = URLDecoder.decode(navBackStackEntry.arguments?.getString("heroName") ?: "Unknown Hero", StandardCharsets.UTF_8.toString())
    val heroImageUrl = URLDecoder.decode(navBackStackEntry.arguments?.getString("heroImageUrl") ?: "", StandardCharsets.UTF_8.toString())
    val heroDescription = URLDecoder.decode(navBackStackEntry.arguments?.getString("heroDescription") ?: "No Description", StandardCharsets.UTF_8.toString())

    Surface(color = MaterialTheme.colorScheme.background, modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = heroImageUrl,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.6f))
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = heroName,
                    fontSize = 30.sp,
                    modifier = Modifier.padding(bottom = 16.dp),
                    color = Color.White
                )
                Text(
                    text = heroDescription,
                    fontSize = 18.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { navController.popBackStack() }) {
                    Text(text = "Back", color = Color.White)
                }
            }
        }
    }
}



