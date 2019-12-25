package sixteen_three_one_one

class Test{
    val data1: Int = 10
}

val Test.data2
    get() = 20

fun main() {
    val obj: Test = Test()
    println("data2: ${obj.data2}")
}