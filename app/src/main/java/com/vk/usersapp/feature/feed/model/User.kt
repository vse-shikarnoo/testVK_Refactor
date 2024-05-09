package com.vk.usersapp.feature.feed.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val firstName: String,
    val lastName: String,
    val image: String,
    val university: String,
) : Parcelable