package ten_two_three_one

interface Interface3{
    fun funA(){
        println("Interface3 funA")
    }
}

open abstract class Super3{
    abstract fun funA()
}

class Sub3: Super3(), Interface3{
    override fun funA(){
        super.funA()
        println("Sub3 funA...")
    }

    fun some(){
        super.funA()
    }
}

fun main(args: Array<String>){
    val obj1 = Sub3()
    obj1.funA()
    obj1.some()
}