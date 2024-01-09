package com.rita.converters

import kotlin.math.sqrt

object NumberControler {
    fun raizQuadrada(srtNumber: String?): Double {
        if(srtNumber.isNullOrBlank()) return 0.0
        val number = srtNumber.replace(",".toRegex(), ".")
        val doubleNumber = number.toDouble()
        val numberRaiz = sqrt(doubleNumber)
        return if (!numberRaiz.isNaN()) numberRaiz else 0.0
    }

    fun convertToDouble(srtNumber: String?): Double {
        if(srtNumber.isNullOrBlank()) return 0.0
        // converte , para .
        val number = srtNumber.replace(",".toRegex(), ".")
        // se for numero retorna ao numero como double se nao 0.0
        return if (isNumeric(number)) number.toDouble() else 0.0
    }

    fun isNumeric(strNumber: String?): Boolean {
        if(strNumber.isNullOrBlank()) return false
        val number = strNumber.replace(",".toRegex(), ".")
        // verificar se é numerico
        return number.matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex())
    }
}