package com.example.ui_addNewAd.ui

    //TODO should decide if we need it for events

//        data class UpdatePetName(
//            var petName: String
//        ): NewAdEvent()

//    data class UpdateOwnerName(
//        val ownerName: String
//    ): NewAdEvent()
//
//    data class UpdatePetAge(
//        val petAge: Int
//    ): NewAdEvent()
//
//    data class UpdateYourPhoneNumber(
//        val phoneNumber: Double
//    ): NewAdEvent()
//
//    data class UpdateYourPlace(
//        val place: String
//    ): NewAdEvent()
//
//    data class UpdateYourPetBreed(
//        val breed: String
//    ): NewAdEvent()
//
//    data class UpdateYourPetSex(
//        val sex: Int
//    ): NewAdEvent()
//
//    data class UpdateYourPetKind(
//        val kind: String
//    ): NewAdEvent()
//
//    data class UpdateYourPetInfo(
//        val info: String
//    ): NewAdEvent()
//
//    data class UpdateYourEmail(
//        val email: String
//    ): NewAdEvent()

    //TODO if we need it for viewModel

//            is NewAdEvent.UpdatePetName -> {
//                state.value.name = state.value.copy(name = event.petName).name
//            }
//            is NewAdEvent.UpdateOwnerName -> {
//                state.value.ownerName = state.value.copy(ownerName = event.ownerName).ownerName
//            }
//            is NewAdEvent.UpdatePetAge -> {
//                state.value.age = state.value.copy(age = event.petAge).age
//            }
//            is NewAdEvent.UpdateYourPetBreed -> {
//                state.value.breed = state.value.copy(breed = event.breed).breed
//            }
//            is NewAdEvent.UpdateYourPhoneNumber -> {
//                state.value.phone = state.value.copy(phone = event.phoneNumber).phone
//            }
//
//            is NewAdEvent.UpdateYourPlace -> {
//                state.value.place = state.value.copy(place = event.place).place
//            }
//            is NewAdEvent.UpdateYourPetInfo -> {
//                state.value.info = state.value.copy(info = event.info).info
//            }
//            is NewAdEvent.UpdateYourEmail -> {
//                state.value.email = state.value.copy(email = event.email).email
//            }


    //TODO in prospect: we can save next fields to cache to preserve user input. Check if there is some automate way to cache inputs

//    var name: String? = null,
//    var ownerName: String? = null,
//    var age: Int? = null,
//    var breed: String? = null,
//    var phone: Double? = null,
////    var sex: Int = 0,
////    val kind: String = "",
//    var place: String? = null,
//    var info: String = "",
//    var email: String? = null