package com.theapplication.playstoreui

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.Games
import androidx.compose.material.icons.filled.VideogameAsset
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route:String,
    val title:String,
    val icon:ImageVector
){
    class Apps():BottomBarScreen(
        route = "route_apps",
        title = "Apps",
        icon = Icons.Default.Apps
    )

    class Games():BottomBarScreen(
        route = "route_games",
        title = "Games",
        icon = Icons.Default.VideogameAsset
    )


}