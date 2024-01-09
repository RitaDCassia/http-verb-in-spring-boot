package com.rita.math

import com.rita.converters.NumberControler
import org.springframework.web.bind.annotation.PathVariable

class SimpleMath {
    fun sum(numberOne: Double, numberTwo: Double) = numberOne + numberTwo
    fun sub(numberOne: Double, numberTwo: Double) = numberOne - numberTwo
    fun mult(numberOne: Double, numberTwo: Double) = numberOne * numberTwo
    fun div(numberOne: Double, numberTwo: Double) = numberOne / numberTwo
    fun media(numberOne: Double, numberTwo: Double) = (numberOne + numberTwo) / 2
    fun raiz(numberOne: String?) = NumberControler.raizQuadrada(numberOne)
}