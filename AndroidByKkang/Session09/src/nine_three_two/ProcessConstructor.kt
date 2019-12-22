package nine_three_two

open class Super{
    constructor(name: String, no: Int){
        println("Super... constructor(name, no)")
    }
    init{
        println("Super... init call...")
    }
}

class Sub(name: String): Super(name, 10){
    constructor(name: String, no: Int): this(name){
        println("Sub... constructor(name, no) call")
    }
    init{
        println("Sub... init call...")
    }
}

fun main() {
    Sub("kkang")
    println("...............................")
    Sub("kkang", 10)
}