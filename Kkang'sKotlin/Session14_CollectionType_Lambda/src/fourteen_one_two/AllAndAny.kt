package fourteen_one_two

class User(val name: String, val age: Int)
var list = listOf(User("kkang", 33), User("lee", 28))

fun main() {
    println("all test: ${list.all{ it.age > 30}}")
    println("any test: ${list.any{ it.age > 30}}")
}