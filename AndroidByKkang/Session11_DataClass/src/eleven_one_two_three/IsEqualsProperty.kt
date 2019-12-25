package eleven_one_two_three

/* equals()는 주생성자의 매개변수가 아닌 보조 생성자의 프로퍼티까지 값까지 비교하는가? false */

data class User(val name: String, val age: Int){
    var email: String = "a@a.com"
}

fun main() {
    val user = User("kkang", 20)

    val user1 = User("kkang", 20)
    user1.email = "b@b.com"

    println(user.equals(user1))
}

