package com.appsolute.entaincodetest.domain.model

/**
 * @author : alexyang - Appsolute
 * @mailto : braveheart3208@mail.com
 * @created : 2/11/2023, Thursday
 **/
sealed class RaceCategory(val id: String) {
    object Greyhound : RaceCategory("9daef0d7-bf3c-4f50-921d-8e818c60fe61")
    object Harness : RaceCategory("161d9be2-e909-4326-8c2c-35ed71fb460b")
    object Horse : RaceCategory("4a2788f8-e825-4d36-9894-efd4baf1cfae")
    object Other : RaceCategory("")

    companion object {
        fun fromString(id: String): RaceCategory {
            return when (id) {
                "9daef0d7-bf3c-4f50-921d-8e818c60fe61" -> Greyhound
                "161d9be2-e909-4326-8c2c-35ed71fb460b" -> Harness
                "4a2788f8-e825-4d36-9894-efd4baf1cfae" -> Horse
                else -> Other
            }
        }
    }
}

fun RaceCategory.description(): String {
    return when (this) {
        is RaceCategory.Greyhound -> "Greyhound"
        is RaceCategory.Harness -> "Harness"
        is RaceCategory.Horse -> "Horse"
        else -> "Other"
    }
}
