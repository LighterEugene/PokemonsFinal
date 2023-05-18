package com.example.pokemons.data

import android.os.Parcel
import android.os.Parcelable

data class Sprites(
    val back_default: String?,
    val back_female: String?,
    val back_shiny: String?,
    val back_shiny_female: String?,
    val front_default: String?,
    val front_female: String?,
    val front_shiny: String?,
    val front_shiny_female: String?,
):Parcelable {
    constructor(parcel: Parcel) : this(
        back_default = parcel.readString(),
        back_female = parcel.readString(),
        back_shiny = parcel.readString(),
        back_shiny_female = parcel.readString(),
        front_default = parcel.readString(),
        front_female = parcel.readString(),
        front_shiny = parcel.readString(),
        front_shiny_female = parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(back_default)
        parcel.writeString(back_female)
        parcel.writeString(back_shiny)
        parcel.writeString(back_shiny_female)
        parcel.writeString(front_default)
        parcel.writeString(front_female)
        parcel.writeString(front_shiny)
        parcel.writeString(front_shiny_female)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Sprites> {
        override fun createFromParcel(parcel: Parcel): Sprites {
            return Sprites(parcel)
        }

        override fun newArray(size: Int): Array<Sprites?> {
            return arrayOfNulls(size)
        }
    }
}