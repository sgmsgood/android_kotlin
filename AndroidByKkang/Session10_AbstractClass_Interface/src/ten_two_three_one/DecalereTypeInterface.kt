package ten_two_three_one

interface Interface4 {
    fun funA() {
        println("Interface4 funA...")
    }
}

interface Interface5{
    fun funA(){
        println("Interface5 funA...")
    }
}

class Sub4: Interface4, Interface5{
    override fun funA(){
        super<Interface4>.funA()
        super<Interface5>.funA()
    }

    fun some(){
        super<Interface5>.funA()
    }
}

fun main() {
    val obj = Sub4()
    obj.funA()
    obj.some()
}