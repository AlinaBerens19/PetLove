package com.example.ui_addNewAd.ui

import android.net.Uri
import android.util.Log
import androidx.compose.ui.text.input.TextFieldValue
import com.example.pet_domain.Pet
import java.util.regex.Pattern


//--------------------------------------------------------------------------------------------------
//TODO move these functions to other place

val String.containsLatinLetter: Boolean
    get() = matches(Regex(".*[A-Za-z].*"))

fun checkPhoneNumber(string: String): Boolean {
    for (c in string) {
        if (c !in 'A'..'Z' && c !in 'a'..'c') {
            return false
        }
    }
    return true
}

fun checkLengthOfInputAboutPet(string: String?): Boolean {
    var res = false
    if (string != null) {
        res = string.length < 100
    }
    return res
}

fun String.isEmailValid(): Boolean {
    val expression = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,8}$"
    val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
    val matcher = pattern.matcher(this)
    return matcher.matches()
}

fun validateNewAd(name: String?, ownerName: String?, email: String?, age: Int?, kind: String,
                  breed: String, phone: Long?, place: String?, info: String, sex: Int, image: Uri?
): Pet?
{
    var images: MutableList<String>? = null

    images?.add(image.toString())

    if (name != "" && ownerName != "" && email != "" &&
        age != null && phone != null && breed != "Choose your pet breed" &&
        place != "" && checkLengthOfInputAboutPet(info) && email!!.isEmailValid() && image != null
    ) {
        Log.w("PET", "name: $name, ownerName: $ownerName, email: $email," +
                "phone $phone, breed: $breed, place: $place, image: $image")
        Log.w("TAG", "images: $images")

        return Pet(
            name = name!!,
            ownerEmail = email,
            ownerName = ownerName!!,
            age = age,
            kind = kind,
            breed = breed,
            ownerPhone = phone.toLong(),
            aboutPetInfo = info,
            place = place!!,
            sex = sex,
            image = image.toString()
        )
    }
    else {
        return null
    }
}

//--------------------------------------------------------------------------------------------------