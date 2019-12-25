package sixteen_one_two_three

class Test{
    fun sayHello(){
        println("Test..sayHello()")
    }
}

fun Test.sayHello(){
    println("Test extension.. sayHello()")
}

fun main() {
    val test = Test()
    test.sayHello()


}