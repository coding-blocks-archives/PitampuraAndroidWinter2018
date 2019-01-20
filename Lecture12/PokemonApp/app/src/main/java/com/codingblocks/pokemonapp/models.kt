package com.codingblocks.pokemonapp

import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    val abilities: ArrayList<Ability> = ArrayList(),
    @SerializedName("base_exp")
    val baseExp: Int = 0,
    val forms: ArrayList<GenericContainerClass> = ArrayList(),
    @SerializedName("game_indices")
    val gameIndices: ArrayList<Index> = ArrayList(),
    val height: Double = 0.0,
    val id: Int = 0,
    @SerializedName("is_default")
    val isDefault: Boolean = false,
    @SerializedName("location_area_encounters")
    val locationAreaEncounters: String = "",
    val name: String = "",
    val order: String = "",
    val weight: Double = 0.0,
    val sprites: Sprite
)

data class Sprite(
    @SerializedName("back_default")
    val backDefault: String = "",
    @SerializedName("back_female")
    val backFemale: String = ""
)

data class Ability(
    val ability: GenericContainerClass = GenericContainerClass(),
    @SerializedName("is_hidden")
    val isHidden: Boolean = false,
    val slot: Int = 0
)


data class Index(
    @SerializedName("game_index")
    val gameIndex: Int = 0,
    val version: GenericContainerClass = GenericContainerClass()
)

class GenericContainerClass(
    val name: String = "",
    val url: String = ""
)