package eight_one_two

class User1 {
    //사용자 정의 프로퍼티
    var greeting: String = "Hello"
        set(value) {
            field = "Hello" + value
        }
        get() = field.toUpperCase()

    var age: Int = 0
        set(value) {
            if (value > 0) {
                field = value
            } else {
                field = 0
            }
        }
}

fun main() {
    val user1 = User1()
    user1.greeting = " kkang"
    println(user1.greeting)

    user1.age = -1
    println("age: ${user1.age}")
}