package com.example.superheroes

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroes.data.Datasource
import com.example.superheroes.ui.theme.SuperheroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperheroesTheme {

            }
        }
    }
}



@Preview(showBackground = true,
    widthDp = 360,
    uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun GreetingPreview() {
    SuperheroesTheme {
        val list = Datasource().loadHeroes()
        HeroesScreen().SuperHeroItem(superHero = list[4])
    }


}