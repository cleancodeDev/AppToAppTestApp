package com.devddun.apptoapptestapp.model

data class User (
    val id : Int,
    val name : String,
    val username : String,
    val email : String,
    val address : AddressInfo,
    val phone : String,
    val webSite : String,
    val company : Company
)

data class AddressInfo (
    val street : String,
    val suite : String,
    val city : String,
    val zipcode : String,
    val geo : Geo
)

data class Company (
    val name : String,
    val catchPhrase : String,
    val bs : String
)

data class Geo (
    val lat : String,
    val lng : String
)