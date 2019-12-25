package fourteen_two_four

fun main() {
    listOf(11, 12, 5, 23, 5, 4).takeWhile { it > 10 }.forEach { println(it) }
}