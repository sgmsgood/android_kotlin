package nineteen_three

typealias MyInt = Int
typealias MList<T> = MutableList<T>
typealias MC = MyClass
typealias MI = MyInterface

typealias MyType = (Int) -> Boolean
val myFun: MyType = { it > 10 }

interface MyInterface
class MyClass: MI

class Super{
    inner class Sub

    fun getSubInsance(): MySub{
        return Sub()
    }
}

typealias MySub = Super.Sub

fun main() {
    val no: MyInt = 10
    val list: MList<String> = mutableListOf("hello", "kkang")
    val obj: MC = MC()
}