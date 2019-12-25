package fourteen_five_two

fun main() {
    listOf(1, 3, 2).sortedBy { it % 3 }.forEach { println(it) }
}