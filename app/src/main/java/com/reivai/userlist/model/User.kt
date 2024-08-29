package com.reivai.userlist.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: String,
    val name: String,
    val avatar: String,
    val city: String,
    val country: String,
    val county: String,
    val address_no: String,
    val street: String,
    val zip_code: String,
    val createdAt: String
) : Parcelable