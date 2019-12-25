package fourteen_two_two

fun main() {
    listOf(21, 1, 12, 5, 23).filterNot { it > 10 }.forEach { println(it) }
}