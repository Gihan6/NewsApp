package com.gihan.newsapp.prsentation.onboarding

import androidx.annotation.DrawableRes
import com.gihan.newsapp.R

data class Page(val title:String,val description:String,@DrawableRes val image:Int)

val pages= listOf(
    Page
        ("Lorem Ipsum Is Simply Dummy" ,
        "Lorem Ipsum Is Simply Dummy text of the printing and testability industry .",
        R.drawable.onboarding1),
    Page
        ("Lorem Ipsum Is Simply Dummy" ,
        "Lorem Ipsum Is Simply Dummy text of the printing and testability industry .",
        R.drawable.onboarding2),
    Page
        ("Lorem Ipsum Is Simply Dummy" ,
        "Lorem Ipsum Is Simply Dummy text of the printing and testability industry .",
        R.drawable.onboarding3)
)
