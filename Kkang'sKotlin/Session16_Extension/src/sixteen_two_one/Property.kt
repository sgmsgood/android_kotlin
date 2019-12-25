package sixteen_two_one

class Test{
    val classData: Int = 0
}

//val Test.extensionData1: Int = 10

val Test.extensionData2: Int
    get() = 10

fun main() {
    val obj = Test()
    println("classData ${obj.classData}...extensionData2 ${obj.extensionData2}")
}