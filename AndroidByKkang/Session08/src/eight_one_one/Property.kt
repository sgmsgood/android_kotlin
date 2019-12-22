package eight_one_one

class User{
    var name: String = "kkang"
    val age: Int = 20
}

fun main() {
    val user = User()

    user.name = "kim"
    println("name: ${user.name}")
    println("age: ${user.age}")
}