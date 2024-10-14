package com.example.superheroes

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.data.Datasource
import com.example.superheroes.model.SuperHero

class HeroesScreen {

    @Composable
    fun SuperHeroName(@StringRes superHeroName: Int, modifier: Modifier = Modifier) {
        Text(
            text = stringResource(id = superHeroName),
            style = MaterialTheme.typography.displaySmall)
    }

    @Composable
    fun SuperHeroDesc(@StringRes superHeroDesc: Int, modifier: Modifier = Modifier) {
        Text(
            text = stringResource(id = superHeroDesc),
            style = MaterialTheme.typography.bodyLarge,

        )
    }

    @Composable
    fun SuperHeroImage(@DrawableRes superHeroIcon: Int, modifier: Modifier = Modifier) {
        Image(
            painter = painterResource(id = superHeroIcon),
            contentDescription = null,
            modifier = modifier
                .size(dimensionResource(id = R.dimen.image_size))
                .clip(MaterialTheme.shapes.small)
        )
    }

    @Composable
    fun SuperHeroItem(superHero: SuperHero, modifier: Modifier = Modifier) {
        Card(
            elevation = CardDefaults
                .cardElevation(defaultElevation = dimensionResource(id = R.dimen.elevation)),
            modifier = modifier
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.medium),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer)
        ) {
            Row(
                modifier = modifier
                    .padding(dimensionResource(id = R.dimen.list_item_padding))
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen.list_item_height)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = modifier
                        .weight(1f)
                ) {
                    SuperHeroName(superHeroName = superHero.nameRes)
                    SuperHeroDesc(superHeroDesc = superHero.descriptionRes)
                }
                Spacer(modifier = modifier
                    .size(dimensionResource(id = R.dimen.padding_between_image_and_text)))
                SuperHeroImage(superHeroIcon = superHero.imageRes)
            }
        }
    }

    @Composable
    fun SuperHeroList(modifier: Modifier = Modifier){
        val list = Datasource().loadHeroes()
        Scaffold (modifier) { it->
            LazyColumn (contentPadding = it){



            }

        }


    }

}
