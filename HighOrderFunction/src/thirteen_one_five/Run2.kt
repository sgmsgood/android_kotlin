package thirteen_one_five

/* run() 함수를 호출한 객체가 람다 함수에 전달됩니다.
*  람다 함수 내에서는 따로 객체를 명시하지 않고 객체의 멤버를 바로 이용할 수 있습니다. */

// 객체지향 프로그래밍
class User(){
    var name: String? = null
    var age: Int? = null

    fun sayHello(){
        println("hello $name")
    }

    fun sayInfo(){
        println("i am $name, $age years old")
    }
}

fun main() {
    // 객체지향 프로그래밍
//    val user = User()
////    user.name = "kkang"
////    user.age = 33
////    user.sayHello()
////    user.sayInfo()

    // Run 함수
    /* run() 함수에 전달하는 람다함수에서 user 객체를 바로 이용할 수 있습니다.
    * 아래와 같이 user.run 을을 이요하면 객체명을 명시하지 않아도 객체의 멤버에 접근할 수 있다는 이야기입니다.*/
    val user = User()
    val runResult = user.run{
        name = "kim"
        age = 28
        sayHello()
        sayInfo()
        10 + 20
    }

    println("run result: $runResult")
}