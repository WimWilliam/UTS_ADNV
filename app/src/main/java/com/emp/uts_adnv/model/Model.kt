package com.emp.uts_adnv.model

data class User(
    val username:String?,
    val password: String?,
    val foto: String?,
    val email: String?,
    val nohp:String?

)
data class Hobys_name(
    val nama:String?,
    val deskripsi:String?,
    val logo:String?
)
data class DetailHobby(
    val nama:String?,
    val photo:String,
    val penulis:String?,
    val isiHobby:String?
)