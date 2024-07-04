@file:OptIn(ExperimentalFoundationApi::class)

package com.example.marvel.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.example.marvel.navigation.Screens

@Composable
fun MainScreen(navController: NavController) {
    Mian(navController = navController)
}
@Composable
fun Mian(navController: NavController) {

    val heroes = listOf(
        Hero("Iron Man", "https://gas-kvas.com/grafic/uploads/posts/2023-09/1695883903_gas-kvas-com-p-kartinki-zheleznogo-cheloveka-2.jpg", "Tony Stark is a billionaire, playboy, and philanthropist who dons an advanced armored suit to become Iron Man."),
        Hero("Captain America", "https://img.championat.com/s/1350x900/news/big/f/s/kris-evans-vnov-pogovoril-pro-vozvraschenie-k-roli-kapitana-amerika_16551155481664123558.jpg", "Steve Rogers is a World War II soldier who is enhanced with super-soldier serum."),
        Hero("Thor", "https://kartinki.pics/uploads/posts/2022-12/1670419854_20-kartinkin-net-p-tor-kartinki-instagram-22.jpg", "The God of Thunder, Thor is a powerful Asgardian who wields the mighty hammer Mjolnir."),
        Hero("Hulk", "https://cvam.ru/wp-content/uploads/2023/10/khalk-kvm-1.webp", "Bruce Banner transforms into the Hulk, a powerful green-skinned giant, when angered."),
        Hero("Black Widow", "https://i.pinimg.com/originals/70/c8/a2/70c8a27e531f3286aceedb42b99a612e.jpg", "Natasha Romanoff is a former KGB assassin and a high-ranking S.H.I.E.L.D. agent."),
        Hero("Hawkeye", "https://afisha.a42.ru/uploads/posters/65/65df4820-5c32-11e9-b4e3-ed93dfc9cf8a.jpg", "Clint Barton is a master archer and a former agent of S.H.I.E.L.D."),
        Hero("Black Panther", "https://media.2x2tv.ru/content/images/size/w1440h1440/2021/01/black.jpg", "T'Challa is the king of Wakanda and the Black Panther, a powerful warrior."),
        Hero("Doctor Strange", "https://www.looper.com/img/gallery/doctor-stranges-cut-death-scene-may-rattle-marvel-fans-but-cast-crew-loved-it/l-intro-1693503143.jpg", "Stephen Strange is a former neurosurgeon who becomes the Sorcerer Supreme."),
        Hero("Spider-Man", "https://resizer.mail.ru/p/774e9025-1987-5965-b786-002c080af9e7/dpr:200/AQAC0swdxg3rcb4cRMbmPpGoyIkMx1LFcJ6vgSiwyMgb_EAexixpcyQBeia808iBT49UtMrYVKQ6afO2SBqjr01tOH0.jpg", "Peter Parker is a teenager who gains spider-like abilities after being bitten by a radioactive spider."),
        Hero("Ant-Man", "https://img1.cgtrader.com/items/1878432/1db4146ce8/ant-man-marvel-2015-3d-model-low-poly-max-obj-mtl.jpg", "Scott Lang is a former thief who becomes Ant-Man with the ability to shrink in size."),
        Hero("Vision", "https://media.wired.com/photos/5c144b2b14a7ba0ab66a43d5/master/w_2560%2Cc_limit/CWG1140_v005_055444.1104.jpg", "Vision is an android created by Ultron and brought to life by the Mind Stone."),
        Hero("Star-Lord", "https://theculturednerd.org/wp-content/uploads/2020/11/3290D6B2-206F-461C-A865-526ED34BB96C-2048x1152.jpeg", "Peter Quill is a human who becomes the leader of the Guardians of the Galaxy."),
        Hero("Gamora", "https://picstatio.com/download/2048x1152/wv-wvn/gamora_guardians_of_the_galaxy_vol_2_4k_hd.jpg", "Gamora is a former assassin and the adopted daughter of Thanos."),
        Hero("Drax", "https://img1.akspic.ru/attachments/crops/5/2/7/5/5/155725/155725-beskonechnaya_vojna_draks-dejv_bautista-mstiteli_beskonechnaya_vojna-draks_razrushitel-gamora-1920x1080.jpg", "Drax the Destroyer is a warrior who seeks revenge for the death of his family."),
        Hero("Rocket", "https://s1.1zoom.ru/b5050/447/Raccoons_Guardians_of_the_Galaxy_Vol._2_Rifles_527767_1600x1200.jpg", "Rocket is a genetically modified raccoon and a member of the Guardians of the Galaxy."),
        Hero("Groot", "https://bogatyr.club/uploads/posts/2023-06/1687547393_bogatyr-club-p-oboi-grut-vkontakte-1.jpg", "Groot is a tree-like creature and a member of the Guardians of the Galaxy."),
        Hero("Nick Fury", "https://f.vividscreen.info/soft/4951ac142f8d899ee45053c634a1eb38/Nick-Fury-Captain-America-The-Winter-Soldier-2048x2048.jpg", "Nick Fury is the former director of S.H.I.E.L.D. and the founder of the Avengers."),
        Hero("Loki", "https://get.wallhere.com/photo/Marvel-Cinematic-Universe-Loki-Tom-Hiddleston-Thor-Ragnarok-Thor-1178407.jpg", "Loki is the God of Mischief and the adopted brother of Thor.")
    )
    val lazyListState = rememberLazyListState()
    val snapBehavior = rememberSnapFlingBehavior(lazyListState = lazyListState)
    Surface(
        color = Color.DarkGray,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(1.dp)) {
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = rememberImagePainter("https://effectiveband.notion.site/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2Fab5510e9-0d2f-404e-9f55-374c7a36d382%2F014c0cb6-64d9-45bd-a3e1-a3cf608257e3%2FUntitled.png?table=block&id=47c3f47d-d604-431d-aa05-6728c63df83d&spaceId=ab5510e9-0d2f-404e-9f55-374c7a36d382&width=2000&userId=&cache=v2"),
                    contentDescription = null,
                    modifier = Modifier.size(170.dp)
                )
                Text(
                    text = "Choose your hero",
                    fontSize = 37.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                LazyRow(
                    state = lazyListState,
                    flingBehavior = snapBehavior
                ) {
                    items(heroes.size) { index ->
                        val hero = heroes[index]
                        HerItem(hero = hero, navController = navController, index = index, listState = lazyListState)
                    }
                }
            }
        }
    }
}

data class Hero(
    val name: String,
    val imageUrl: String,
    val description: String
)



@Composable
fun HerItem(hero: Hero, navController: NavController, index: Int, listState: LazyListState) {
    val visibleItemsInfo = listState.layoutInfo.visibleItemsInfo
    val itemInfo = visibleItemsInfo.find { it.index == index }
    val center = listState.layoutInfo.viewportEndOffset / 2
    val itemCenter = itemInfo?.let { (it.offset + it.size / 2) } ?: 0
    val distanceToCenter = kotlin.math.abs(center - itemCenter)
    val scaleFactor = 1f - (distanceToCenter / center.toFloat()) * 0.3f

    val cardSize by animateDpAsState(targetValue = (600.dp * scaleFactor).coerceIn(400.dp, 600.dp))

    Card(
        modifier = Modifier
            .padding(10.dp)
            .width(cardSize * 0.6f)
            .height(cardSize)
            .clickable {
                navController.navigate(
                    Screens.HeroScreen.createRoute(
                        hero.name, hero.imageUrl, hero.description
                    )
                )
            }
    ) {
        AsyncImage(
            model = hero.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
    }
}
