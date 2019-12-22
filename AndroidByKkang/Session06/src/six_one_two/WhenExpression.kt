package six_one_two

val data6 = 3

val result2 = when(data6){
    1 -> "1...."
    2 -> "2...."
    else -> {
        println("else...")
        "hello"
    }
}

fun main() {
    println(result2)
}