package com.stglucosa.sosaw.stach.model

data class Contactos(
    var name: String,
    var tel:Double,
    var flagKindContacta:Boolean
) {
    override fun toString(): String {
        return "Contactos(name='$name', tel=$tel, flagKindContacta=$flagKindContacta)"
    }
}