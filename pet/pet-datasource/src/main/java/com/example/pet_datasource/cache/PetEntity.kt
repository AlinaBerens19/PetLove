package com.example.pet_datasource.cache

import com.example.herodatasource.cache.Pet_Entity
import com.example.pet_domain.Pet



fun Pet_Entity.toPet(): Pet {
    return Pet(
        id = id,
        kind = kind,
        name = name,
        age = age!!.toInt(),
        breed = breed,
        sex = sex!!.toInt(),
        ownerSex = ownerSex!!.toInt(),
        place = place,
        ownerName = ownerName,
        ownerPhone = ownerPhone,
        ownerEmail = ownerEmail,
        aboutPetInfo = aboutPetInfo,
        likes = likes!!.toInt(),
        images = imagesToList(firstImage, secondImage, thirdImage, forthImage, fifthImage),
        image = firstImage,
    )
}

fun imagesToList(
    first: String?,
    second: String?,
    third: String?,
    forth: String?,
    fifth: String?
): List<String>?
{
    val images: MutableList<String> = mutableListOf()

    if (first == null && second == null && third == null && forth == null && fifth == null) {
        return null
    }
    if(first != null) {
        images.add(first)
    }
    if (second != null) {
        images.add(second)
    }
    if (third != null) {
        images.add(third)
    }
    if (forth != null) {
        images.add(forth)
    }
    if (fifth != null) {
        images.add(fifth)
    }


    return images
}












