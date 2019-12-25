package fourteen_two_three

fun main() {
    listOf(1, 12, 5, 23, 5, 4).dropLastWhile { it < 10 }.forEach { println(it) }
}