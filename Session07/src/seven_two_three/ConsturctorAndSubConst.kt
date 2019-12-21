package seven_two_three

/*
class User1(name: String){
    constructor(name: String, age: Int){

    }
} -> 에러: 주 생성자를 선언했다면 보조 생성자는 무조건 주 생성자를 함께 호출해주어야 합니다.*/

class User1(name: String){
    init {
        println("init block... $name")
    }

    constructor(name: String, age: Int): this(name){
        println("constructor..$name...$age")
    }
}

fun main() {
    println("----- 주 생성자로 생성한 경우 -----")
    val user1 = User1("Elena")

    println("----- 보조 생성자로 생성한 경우 -----")
    val user2 = User1("Jaser", 33)
}
