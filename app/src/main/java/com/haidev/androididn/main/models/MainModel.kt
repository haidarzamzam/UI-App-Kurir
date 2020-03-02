package com.haidev.androididn.main.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MainModel(
    var num: String,
    var name: String,
    var receipt: String,
    var address: String,
    var image: String
) : Parcelable