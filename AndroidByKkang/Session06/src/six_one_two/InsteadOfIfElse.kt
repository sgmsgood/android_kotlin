package six_one_two

val data5 = 15

fun main() {
    when {
        data5 <= 10 -> println("data5 < 10")
        data5 > 10 && data5 <= 20 -> println("10 < data5 <= 20")
        else -> println("data5 > 20")
    }
}
