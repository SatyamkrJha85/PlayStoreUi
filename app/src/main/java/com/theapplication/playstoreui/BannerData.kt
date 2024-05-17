package com.theapplication.playstoreui

data class BannerData(
    val bannerimg:String="",
    val titleinfo:String="",
    val update:String="",
    val bannerlogo:String="",
    val smalltitle:String="",
    val studioname:String="",
    val rating:String="",
    )

val bannermaindata : List<BannerData> = listOf(
    BannerData(
        bannerimg = "https://assets-global.website-files.com/63f8ef5c5a8680f76905bcd2/649de9d01320f61b393ca758_Paw%20Wesbite_OG%20Image_1200x630.jpg",
        titleinfo = "PAW PATROL WORLD KIDS GAME",
        update = "New update available",
        bannerlogo = "https://1000logos.net/wp-content/uploads/2018/02/Paw-Patrol-Logo.png",
        smalltitle = "Paw patrol Rescue..",
        "Budge Studio",
        rating = "4.2"
    ),

)