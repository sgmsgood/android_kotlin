package thirteen_one_five

/* Apply 함수는 Run 함수와 같이 값을 반환해줍니다.
*   - Run 함수는 전달받는 람다 함수의 반환값을 그대로 반환하지만,
*   - apply() 함수는 applay() 함수를 적용한 개체를 반환합니다. */

class User2() {
    var name: String? = null
    var age: Int? = null

    fun sayHello() {
        println("hello $name")
    }

    fun sayInfo() {
        println("i am $name, $age years old")
    }
}

fun main() {
    val user2 = User2()
    val user3 = user2.apply {
        name = "park"
        sayHello()
        sayInfo()
    }

    println("user name: ${user3.name}, user3 name: ${user3.name}")

    user3.name = "aaa"
    user3.age = 20
    println("user name: ${user3.name}, user3 name: ${user3.name}")
}