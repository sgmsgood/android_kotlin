package com.opusone.leanon.testcalculator

object Calculator {
    fun sum(l: Double, r: Double):Double{
        return l + r
    }

    fun minus(l: Double, r: Double): Double{
        return l - r
    }

    fun multiple(l: Double, r: Double): Double{
        return l * r
    }

    fun division(l: Double, r: Double): Double{
        if(l == 0.0 || r == 0.0){
            return 0.0
        }
        return l / r
    }

    fun cal(l:Double, r:Double, op:(Double, Double) -> Double): Double{
        return op(l, r)
    }
}