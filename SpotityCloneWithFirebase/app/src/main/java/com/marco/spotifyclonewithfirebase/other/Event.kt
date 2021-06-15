package com.marco.spotifyclonewithfirebase.other

open class Event <out T>(private val data: T){
    var hasBeenHandle = false
        private set
    fun getContentIfNotHandled(): T?{
        return  if(hasBeenHandle){
            null
        }else{
            hasBeenHandle = true
            data
        }
    }
    fun peekCotent() = data

}