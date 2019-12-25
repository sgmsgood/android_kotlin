package fourteen_four_four

fun main() {
    val result1 = listOf(2, 5, 10, 2).indexOfFirst { it % 2  == 0}
    println("indexOfFirst test: $result1")
}