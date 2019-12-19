package twelve_two_four

class User(val name: String, val age: Int)

val lambdas2: (User) -> Int = { it.age }

val lambdas3: (User) -> Int = User::age

fun main() {

    val lambdas1: (User) -> Int = { user: User -> user.age }
    println("lambdas1 return: ${lambdas1(User("kkang", 33))}")
    println(lambdas2(User("Elen", 30)))
    println("lambdas3 return: ${lambdas3(User("kkang", 33))}")
}