package five_one_three

fun getLength(obj: Any): Int{
    if(obj is String){
        return obj.length
    }
    return 0
}

fun case(obj: Any): String{
    when(obj){
        1 -> return "One"
        "Hello" -> return "Greeting"
        is Long -> return "Long"
        !is String -> return "Not a string"
        else -> return "unknown"
    }
}

fun main() {
    println(getLength("Hello"))
    println(getLength(10))

    println("case: ${case(1)}")
}