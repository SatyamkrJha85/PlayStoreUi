package com.theapplication.playstoreui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.MicNone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.theapplication.playstoreui.ui.theme.Blue
import com.theapplication.playstoreui.ui.theme.BlueGray
import com.theapplication.playstoreui.ui.theme.BrightBlue
import com.theapplication.playstoreui.ui.theme.Gray
import com.theapplication.playstoreui.ui.theme.NavyBlue


data class AppModel(
    var appName: String = "",
    var appimgurl: String = "",
    var appRating: String = "0.0"
)

data class AppCategory(
    var appCategory: String = "",
    var list: List<AppModel> = emptyList()
)


@Composable
fun PlayStoreTab(
    listoftabs: List<String> = listOf(
        "For You",
        "Top charts",
        "Children",
        "Premium",
        "Categories"
    ), selectedIndex: Int = 0, currenettabPosition: (position: Int) -> Unit = {}
) {
    ScrollableTabRow(
        selectedTabIndex = selectedIndex,
        edgePadding = 0.dp,
        containerColor = Color.Transparent,
        indicator = { tabPositions ->
            Box(
                modifier = Modifier
                    .tabIndicatorOffset(tabPositions[selectedIndex])
                    .height(2.dp)
                    .padding(horizontal = 20.dp)
                    .background(
                        color = BrightBlue,
                        shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)
                    )
            )
        },
    ) {
        listoftabs.forEachIndexed { index, s ->
            Tab(
                selected = index == selectedIndex,
                onClick = { currenettabPosition(index) },
                modifier = Modifier.padding(8.dp)
            ) {
                if (selectedIndex == index) {
                    Text(text = s, color = BrightBlue)
                } else {
                    Text(text = s)
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PlayStoreTabprev() {
    PlayStoreTab()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Appsearchbar() {
    Surface(
        shape = RoundedCornerShape(32.dp),
        color = Gray
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = "", onValueChange = {},
                modifier = Modifier.weight(1f),
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = null)
                },
                placeholder = {
                    Text(
                        text = "Search for Apps & Games..", fontSize = 14.sp,
                        style = MaterialTheme.typography.titleMedium
                    )
                },
                trailingIcon = {
                    Icon(imageVector = Icons.Filled.MicNone, contentDescription = null)
                }, colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    errorContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(BlueGray, CircleShape)
            ) {
                Text(
                    text = "S", color = Color.White, fontSize = 19.sp, modifier = Modifier.align(
                        Alignment.Center
                    )
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun Appsearchbarprev() {
    Appsearchbar()
}

@Composable
fun AppItem(appModel: AppModel = AppModel(), modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier.width(80.dp)
    ) {
        Card(
            elevation = CardDefaults.cardElevation(4.dp),
            colors = CardDefaults.cardColors(Color.White),
            shape = RoundedCornerShape(16.dp)
        ) {
            AsyncImage(
                model = appModel.appimgurl,
                contentDescription = "",
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.ic_launcher_background),
                modifier = Modifier
                    .size(88.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = appModel.appName, fontSize = 15.sp)

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(text = appModel.appRating, fontSize = 14.sp)
            Icon(
                imageVector = Icons.Default.Star, contentDescription = null,
                modifier = Modifier.size(16.dp)
            )
        }


    }
}


@Composable
private fun AppList(
    applist: List<AppModel> = listOf(
        AppModel("satyamsatyamsatyamsatyamsatyam", "", "3.4"),
        AppModel("satyam", ""),
        AppModel("satyam", "")

    ), modifier: Modifier = Modifier
) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(applist) {
            AppItem(it)
        }
    }
}


@Composable
fun AppCategoryHeader(headertitle: String = "hello users") {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = headertitle, style = MaterialTheme.typography.titleMedium)
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Filled.ArrowForward, contentDescription = null)
        }
    }
}


@Composable
fun AppcategoryItem(appCategory: AppCategory = AppCategory()) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        AppCategoryHeader(appCategory.appCategory)
        AppList(appCategory.list)
    }
}


@Composable
fun AppCategoryList(appCategorylist: List<AppCategory> = emptyList()) {
    LazyColumn(
        contentPadding = PaddingValues(start = 8.dp)
    ) {
        items(appCategorylist) {
            AppcategoryItem(it)
        }
    }
}


@Composable
fun AppSection() {
    val appCat1 = listOf(
        AppModel(
            "Adobe XD",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c2/Adobe_XD_CC_icon.svg/1200px-Adobe_XD_CC_icon.svg.png",
            "4.2"
        ),
        AppModel(
            "Google Tasks",
            "https://play-lh.googleusercontent.com/pjUulZ-Vdo7qPKxk3IRhnk8SORPlgSydSyYEjm7fGcoXO8wDyYisWXwQqEjMryZ_sqK2",
            "4.6"
        ),
        AppModel(
            "Google Lens",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f9/Google_Lens_-_new_logo.png/768px-Google_Lens_-_new_logo.png",
            "4.5"
        ),
        AppModel(
            "Google Analytics",
            "https://logos-world.net/wp-content/uploads/2021/02/Google-Analytics-Emblem.png",
            "4.2"
        ),
        AppModel(
            "Google Fit",
            "https://gstatic.com/images/branding/product/1x/gfit_512dp.png",
            "4.3"
        ),
    )

    val appCat2 = listOf(
        AppModel(
            "inDrive",
            "https://play-lh.googleusercontent.com/xCJ6Mf_zjRLSzLfnHj0xe8gcdSLvE0LcszosTsCNzprlf0oLfPr4Ikewq1CcGBpisfo",
            "4.2"
        ),
        AppModel(
            "Whatsapp",
            "https://www.freepnglogos.com/uploads/whatsapp-logo-png-hd-2.png",
            "4.6"
        ),
        AppModel(
            "foodpanda",
            "https://play-lh.googleusercontent.com/1keEOkk2GrxZpaRH73-vDqpAXhJNU9tbP5mfk82X6YxH8EhnU2JPOb5w1FLUJiqkEg",
            "4.5"
        ),
        AppModel(
            "Cricket League",
            "https://static.vecteezy.com/system/resources/previews/000/365/307/original/cricket-logo-vector.jpg",
            "4.2"
        ),
        AppModel(
            "Easypaisa",
            "https://play-lh.googleusercontent.com/uQULm-1ktLYWr6_we1zlOoZmp6AGXcfugF3kjhRwAxnQ1JZhe20BSJBKhFyHnKgcwA",
            "4.3"
        ),
    )

    val appCat3 = listOf(
        AppModel(
            "Microsoft Office",
            "https://cdn.icon-icons.com/icons2/1156/PNG/512/1486565573-microsoft-office_81557.png",
            "4.2"
        ),
        AppModel(
            "OctaFX",
            "https://play-lh.googleusercontent.com/Andj-7XevaEn8myJvkt4JWwKlRU4wAmub6NstAB5aa4lqbknM9b_dIPUx5JV_ImgvZo",
            "4.6"
        ),
        AppModel(
            "PUBG MOBILE",
            "https://play-lh.googleusercontent.com/JRd05pyBH41qjgsJuWduRJpDeZG0Hnb0yjf2nWqO7VaGKL10-G5UIygxED-WNOc3pg",
            "4.5"
        ),
        AppModel(
            "Spotify",
            "https://www.freepnglogos.com/uploads/spotify-logo-png/spotify-icon-green-logo-8.png",
            "4.2"
        ),
        AppModel(
            "Clash of Clans",
            "https://play-lh.googleusercontent.com/JMNWaZel_qg6qj8T0bjX5OeLvXdka4hxzT_rsSVe5qQWHg798GmJcZetlQYm9-VlTsk",
            "4.3"
        ),
    )

    val list = listOf(
        AppCategory("Based on your recent activity", appCat1),
        AppCategory("Suggested for you", appCat2),
        AppCategory("Recommended for you", appCat3),
    )

    var tabPosition by remember {
        mutableStateOf(0)
    }

    Column {


        PlayStoreTab(selectedIndex = tabPosition, currenettabPosition = { tabPosition = it })
        Spacer(modifier = Modifier.height(16.dp))
        AppBannerDataList()
        Spacer(modifier = Modifier.height(16.dp))
        AppCategoryList(list)

    }

}

@Preview(showSystemUi = true)
@Composable
private fun AppSectionprev() {
    AppSection()
}

@Composable
fun Playstorebotoombar(
    navList: List<BottomBarScreen> = listOf(
        BottomBarScreen.Apps(),
        BottomBarScreen.Games(),
    )

) {
    var selectedcolor = remember {
        mutableStateOf(BrightBlue)
    }

    NavigationBar {
        navList.forEachIndexed { index, bottomBarScreen ->
            NavigationBarItem(selected = true,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = BrightBlue,
                    unselectedIconColor = Gray,
                    indicatorColor = BrightBlue
                ),
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        imageVector = bottomBarScreen.icon,
                        contentDescription = bottomBarScreen.title,
                        tint = NavyBlue
                    )
                },
                label = {
                    Text(text = bottomBarScreen.title)
                }
            )
        }
    }
}

@Composable
fun AppScreen() {
    Scaffold(
        topBar = {

            Box(modifier = Modifier.padding(16.dp)) {
                Appsearchbar()
            }
        },
        bottomBar = {
            Playstorebotoombar()
        }
    ) {
        Column(
            modifier = Modifier.padding(paddingValues = it)
        ) {

            Box(modifier = Modifier.padding(5.dp)) {
                AppSection()
            }
        }

    }
}

@Preview
@Composable
private fun AppScreenprev() {
    AppScreen()

}

@Composable
fun AppBannerDataList() {
    LazyRow {
        items(bannermaindata){
            AppBanner(bannerData = it)
        }
    }
}

@Composable
fun AppBanner(bannerData: BannerData) {
    Column {
        Box(modifier = Modifier
            .width(350.dp)
            .height(250.dp)
            .padding(5.dp)
            .clip(shape = RoundedCornerShape(16.dp))) {
            AsyncImage(model = bannerData.bannerimg,
                contentDescription = "",
                placeholder = painterResource(id = R.drawable.ic_launcher_background),
                contentScale = ContentScale.Crop
                )

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomEnd)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Blue, Blue, Blue, Blue
                            )
                        ), shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)
                    )
            ){

                AsyncImage(model = bannerData.bannerlogo, contentDescription = "", modifier = Modifier
                    .width(80.dp)
                    .height(50.dp)
                    .clip(shape = RoundedCornerShape(14.dp)))
                Column {
                    Column {
                        Text(text = bannerData.smalltitle, color = Color.Black)
                        Text(text = bannerData.studioname, color = Color.Black, fontSize = 13.sp)
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                ) {
                                Text(text = bannerData.rating, color = Color.Black)
                                Icon(
                                    imageVector = Icons.Default.Star, contentDescription = null,
                                    tint = Color.Black,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                            ElevatedButton(modifier = Modifier
                                .padding(end = 20.dp, bottom = 10.dp)
                                .width(90.dp)
                                .height(35.dp), colors = ButtonDefaults.buttonColors(containerColor = BrightBlue), onClick = { /*TODO*/ }) {
                                Text(text = "Install")
                            }
                        }
                    }
                }
            }
        }
    }
}


