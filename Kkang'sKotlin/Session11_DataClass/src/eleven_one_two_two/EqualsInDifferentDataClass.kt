package eleven_one_two_two
/* equals는 다른 클래스의 데이터를 비교하지는 않습니다. */

data class User(val name: String, val age: Int)

data class Person(val name: String, val age: Int)

fun main(){
    val user = User("kkang", 20)
    val person = Person("kkang", 20)

    println(user.equals(person))
}