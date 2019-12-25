package fourteen_three_one

fun main() {
    listOf(1, 2, 3).mapIndexed{index, data -> index * data}.forEach { println(it) }
}