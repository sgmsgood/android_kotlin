package nine_four_three

open class Super{
    fun superFun(){
        println("superFun()...")
    }
}

class Sub1: Super(){
    fun subFun1(){
        println("subFun1()....")
    }
}

class Sub2: Super(){
    fun subFun2(){
        println("subFun2()....")
    }
}

fun main() {
    val obj7: Super? = null
    val obj8: Sub1 = obj7 as Sub1

    val obj9: Super? = null
    val obj10: Sub1? = obj7 as? Sub1
}