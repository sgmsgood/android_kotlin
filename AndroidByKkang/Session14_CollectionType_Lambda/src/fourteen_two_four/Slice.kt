package fourteen_two_four

fun main() {
    listOf(1, 12, 5, 23, 5, 4).slice(1 .. 3).forEach { println("first: $it") }

    listOf(1, 12, 5, 23, 5, 4).slice(listOf(0, 2, 4)).forEach { println("second: $it") }
}