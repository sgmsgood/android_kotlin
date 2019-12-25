package fourteen_four_three

fun main() {
    val result1 = listOf(2, 5, 10, 8).first { it % 5 == 0}
    println("first test: $result1")
}