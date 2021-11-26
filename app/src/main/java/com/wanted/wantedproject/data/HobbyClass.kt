package com.wanted.wantedproject.data

import java.io.Serializable

data class HobbyClass(
    val class_id : String,
    val category_id : String,
    val class_name : String,
    val nickname : String,
    val sai__change_ : Int,
    val fee : Int,
    val start_date : String,
    val introduce_img_root : String
) : Serializable
