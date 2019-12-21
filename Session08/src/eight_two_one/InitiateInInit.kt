package eight_two_one

class User{
    var data: String
    val data2: Int

    init{
        data = "kkang"
        data2 = 10
    }
}

fun main() {
    val user = User()
    println("data: ${user.data}")
    println("data2: ${user.data2}")
}