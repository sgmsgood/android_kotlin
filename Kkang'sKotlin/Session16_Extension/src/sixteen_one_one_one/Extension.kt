package sixteen_one_one_one

class Super{
    val superData: Int = 10
    fun superFun(){
        println("superFun....")
    }
}

val Super.subData: Int
    get() = 20

fun Super.subFun(){
    println("subFun...")
}

fun main() {
    val obj: Super = Super()
    println("superData: ${obj.superData}, subData: ${obj.subData}")
    obj.superFun()
    obj.subFun()
}