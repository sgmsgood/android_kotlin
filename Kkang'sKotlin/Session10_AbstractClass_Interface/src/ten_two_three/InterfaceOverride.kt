package ten_two_three

interface Interface1{
    fun funA()
}

interface Interface2{
    fun funA()
}

open abstract class Super2{
    abstract fun funA()
}

class Sub2: Super2(), Interface1, Interface2{
    override fun funA(){
        println("Sub2 funA..")
    }
}

fun main() {
    val obj1 = Sub2()
    obj1.funA()
}