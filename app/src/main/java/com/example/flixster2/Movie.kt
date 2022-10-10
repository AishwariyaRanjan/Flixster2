package com.example.flixster2

import android.support.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class Movie (
//    @JvmField
    @SerializedName("title")
    var title : String? = null,

    @SerializedName("overview")
    var description : String? = null,

    @SerializedName("poster_path")
    var movieImageUrl : String? = null,

    @SerializedName("release_date")
    var release_date : String? = null,

    @SerializedName("vote_average")
    var vote_average : String? = null,
) : java.io.Serializable