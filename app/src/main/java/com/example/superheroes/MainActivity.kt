package com.example.superheroes

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroes.ui.theme.SuperheroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperheroesTheme {
                Surface (modifier = Modifier.fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)) {
                    SuperHeroesApp();
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable fun SuperHeroesTopAppBar(modifier: Modifier = Modifier){
        CenterAlignedTopAppBar(title = {
            Text(text = "Superheroes",
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.inverseSurface);
        });
}

@Composable
fun SuperHeroesApp(modifier: Modifier = Modifier){
    Scaffold (
        topBar = { SuperHeroesTopAppBar() }
    ) { it ->
        HeroesScreen().SuperHeroList(contentPadding = it);


    }

}



@Preview(showBackground = true,
    widthDp = 360,
    uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun SuperheroesPreview() {
    SuperheroesTheme {
        SuperHeroesApp();
    }


}