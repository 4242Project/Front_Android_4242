package com.wanted.wantedproject.data

data class Register(
    var id :  String,
    var pw : String,
    var univid : String,
    var name : String,
    var email : String,
    var nickname : String,
    var age :  Int,
    var profile_img_root : String,
    var phone : String,
    var department : String,
    var refreshtoken  : String = "N"
)
