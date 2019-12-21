package seven_two_three

import kotlin.test.assertEquals

class User2(name: String){
    init{
        println(name)
    }
    constructor(name: String, age: Int): this(name){

    }
    constructor(name:String, age: Int, email: String): this(name, age){

    }
}

fun main() {
    val user3 = User2("kkang")
    val user4 = User2("kkang", 20)
    val user5 = User2("kkang", 20, "sgmsgood@gmail.com")


}