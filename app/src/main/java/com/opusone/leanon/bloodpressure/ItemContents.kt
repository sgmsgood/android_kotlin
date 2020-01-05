package com.opusone.leanon.bloodpressure

data class ItemContents(var pressure: String, var purse: String) {
    override fun toString(): String {
        return "Content(pressure='$pressure', purse='$purse'"
    }
}