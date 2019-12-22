package six_one_two

val a2 = 1
val data1 = "hello"
val data2 = 10

val some = { ->
    50
}

val data3 = 15

val list = listOf<String>("hello", "world", "kkang")
val array = arrayOf<String>("one", "two", "three")

val data4 = "kkang"

fun main(args: Array<String>) {
    when (a2) {
        1 -> println("a2 == 1")
        2 -> println("a2 == 2")
        else -> println("a2 is neither 1 nor 2")
    }

    when(data1){
        "hello" -> println("data1 is hello")
        "world" -> println("data1 is world")
        else -> println("data1 is not hello or world")
    }

    when(data2){
        10, 20 -> println("data2 is 10 or 20")
        30, 40 -> println("data2 is 30 or 40")
        some() -> println("data2 is 50")
        30 + 30 -> println("data2 is 60")
    }

    println(some())

    when(data3){
        !in 1..100 -> println("invalid data")
        in 1..10 -> println("1 <= $data3 <= 10")
        in 11..20 -> println("11 <= $data3 <== 20")
        else -> println("data3 > 20")
    }

    when(data4){
        in list -> println("data4 in list")
        in array -> println("data4 in array")
    }
}