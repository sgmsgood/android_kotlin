package seven_one_two

class MyClass {
    var name: String = "world"

    fun sayHello() {
        println("hello $name")
    }
}


class Person(val name: String, val age: Int) {

}

class Person2 {

}

fun main() {
    val obj1 = MyClass()
    val obj2 = MyClass()
}