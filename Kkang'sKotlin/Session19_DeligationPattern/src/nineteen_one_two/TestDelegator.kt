package nineteen_one_two

class Test {
    var sum: Int = 0
        get() = field
        set(value){
            field = 0
            for(i in 1..value){
                field += i
            }
        }
}

fun main() {
    val obj: Test = Test()
    obj.sum = 10
    println(obj.sum)
    obj.sum = 5
    println(obj.sum)
}