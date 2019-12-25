package sixteen_one_two_two

open class Super

class Sub: Super()

fun Super.sayHello(){
    println("Super..sayHello()")
}

fun Sub.sayHello(){
    println("Super..sayHello()")
}

fun some(obj: Super){
    obj.sayHello()
}

fun main() {
    some(Sub())
}