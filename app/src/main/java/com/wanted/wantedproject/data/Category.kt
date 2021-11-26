package com.wanted.wantedproject.data

data class Category(
    var categoryImg : Int,
    var categorySubject : String
)

data class StampCategory(
    var categoryImg : Int,
    var categorySubject : String,
    var imgName : Int
)

data class MyStamp(
    var categorySubject : String
)
