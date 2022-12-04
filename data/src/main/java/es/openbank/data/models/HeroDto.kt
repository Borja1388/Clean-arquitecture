package es.openbank.data.models

import com.google.gson.annotations.SerializedName
import es.openbank.domain.model.Hero
import es.openbank.domain.model.Wand

data class HeroDto(
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("alternate_names")
    var alternateNames: ArrayList<String> = arrayListOf(),
    @SerializedName("species")
    var species: String? = null,
    @SerializedName("gender")
    var gender: String? = null,
    @SerializedName("house")
    var house: String? = null,
    @SerializedName("dateOfBirth")
    var dateOfBirth: String? = null,
    @SerializedName("yearOfBirth")
    var yearOfBirth: Int? = null,
    @SerializedName("wizard")
    var wizard: Boolean? = null,
    @SerializedName("ancestry")
    var ancestry: String? = null,
    @SerializedName("eyeColour")
    var eyeColour: String? = null,
    @SerializedName("hairColour")
    var hairColour: String? = null,
    @SerializedName("wand")
    var wand: WandDto? = WandDto(),
    @SerializedName("patronus")
    var patronus: String? = null,
    @SerializedName("hogwartsStudent")
    var hogwartsStudent: Boolean? = null,
    @SerializedName("hogwartsStaff")
    var hogwartsStaff: Boolean? = null,
    @SerializedName("actor")
    var actor: String? = null,
    @SerializedName("alternate_actors")
    var alternateActors: ArrayList<String> = arrayListOf(),
    @SerializedName("alive")
    var alive: Boolean? = null,
    @SerializedName("image")
    var image: String? = null
)

fun HeroDto.toDomain() =
    Hero(
        name = name ?: "",
        alternateNames = alternateNames,
        species = species ?: "",
        gender = gender ?: "",
        house = house ?: "",
        dateOfBirth = dateOfBirth ?: "",
        yearOfBirth = yearOfBirth ?: 0,
        wizard = wizard ?: false,
        ancestry = ancestry ?: "",
        eyeColour = eyeColour ?: "",
        hairColour = hairColour ?: "",
        wand = wand?.toDomain() ?: Wand("","",0f),
        patronus = patronus ?: "",
        hogwartsStudent = hogwartsStudent ?: false,
        hogwartsStaff = hogwartsStaff ?: false,
        actor = actor ?: "",
        alternateActors = alternateActors,
        alive = alive ?: false,
        image = image ?: ""

    )