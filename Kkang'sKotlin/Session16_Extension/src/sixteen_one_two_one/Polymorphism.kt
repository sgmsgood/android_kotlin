package sixteen_one_two_one

open class Super{
    open fun sayHello(){
        println("Super1..sayHello()")
    }
}

class Sub: Super(){
    override fun sayHello(){
        println("Sub1..sayHello()")
    }
}

fun some(obj: Super){
    obj.sayHello()
}

fun main(args: Array<String>){
    some(Sub())
}