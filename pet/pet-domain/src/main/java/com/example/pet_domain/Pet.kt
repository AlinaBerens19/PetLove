package com.example.pet_domain



import java.util.UUID.randomUUID

data class Pet(
    val id: String = randomUUID().toString(),
    var kind: String = "",
    var name: String,
    var age: Int,
    var breed: String,
    var sex: Int = 0,
    var ownerSex: Int = 0,
    var place: String,
    var ownerName: String,
    var ownerPhone: Long,
    var ownerEmail: String,
    var aboutPetInfo: String = "",
    var likes: Int = 0,
    var images: List<String>? = null,
    var image: String? = null
)

