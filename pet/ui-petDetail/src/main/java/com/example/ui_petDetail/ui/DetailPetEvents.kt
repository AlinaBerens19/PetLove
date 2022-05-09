package com.example.ui_petDetail.ui




sealed class DetailPetEvents {

    data class GetPetFromCache(
        val id: String
    ): DetailPetEvents()


}