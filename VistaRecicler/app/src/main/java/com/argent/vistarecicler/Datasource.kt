package com.argent.vistarecicler
import Dog
import android.content.Context
import java.util.*
import kotlin.collections.ArrayList

class Datasource(val context: Context) {
    fun getDogList(): ArrayList<Dog> {
        // Return dog list from string resources
        var dogStrings= context.resources.getStringArray(R.array.dog_array)
        var dogs= ArrayList<Dog>(0)
        dogStrings.forEach {
            var imagensrc=it.lowercase(Locale.ROOT).replace(" ", "")
            var imagen=context.resources.getIdentifier(imagensrc, "drawable",context.packageName)
            dogs.add(Dog(it,imagen))
        }
        return dogs
    }
}