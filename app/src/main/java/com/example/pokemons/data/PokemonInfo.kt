package com.example.pokemons.data

import android.os.Parcel
import android.os.Parcelable

class PokemonInfo(
    val height: Int, //cm
    val name: String?, //name
    val sprites: Sprites?,
    val types: Type?, // type
    val weight: Int //kg
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readParcelable(Sprites::class.java.classLoader),
        parcel.readParcelable(Type::class.java.classLoader),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(height)
        parcel.writeString(name)
        parcel.writeParcelable(sprites, flags)
        parcel.writeParcelable(types, flags)
        parcel.writeInt(weight)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PokemonInfo> {
        override fun createFromParcel(parcel: Parcel): PokemonInfo {
            return PokemonInfo(parcel)
        }

        override fun newArray(size: Int): Array<PokemonInfo?> {
            return arrayOfNulls(size)
        }
    }
}