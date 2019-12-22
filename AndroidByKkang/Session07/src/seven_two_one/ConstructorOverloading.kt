package seven_two_one

class ConstructorOverloadingUser4{
    constructor(){}
    constructor(name: String){}
    constructor(name: String, age: Int){}
}

fun main() {
    val user5 = ConstructorOverloadingUser4()
    val user6 = ConstructorOverloadingUser4("elena")
    val user7 = ConstructorOverloadingUser4("jasper", 20)
}