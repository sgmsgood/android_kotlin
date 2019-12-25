package eight_two_four

val someData: String by lazy{
    println("i am someData lazy...")
    "hello"
}

class User1{
    val name: String by lazy{
        println("i am name lazy...")
        "kkang"
    }

    val age: Int by lazy{
        println("i am age lazy...")
        10
    }

    init{
        println("i am init...")
    }

    constructor(){
        println("i am constructor")
    }
}

fun main() {
    //lazy 초기화
    val user1 = User1()
    println("name use before...")
    println("name: ${user1.name}")
    println("name use after")
    println("age use before")
    println("age: ${user1.age}")
    println("age use after...")
}
