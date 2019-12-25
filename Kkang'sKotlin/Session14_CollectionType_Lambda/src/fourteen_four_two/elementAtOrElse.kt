package fourteen_four_two

fun main() {
    val result1 = listOf(2,5,10, 8).elementAtOrElse(5, {0})
    println("elementAtOrElse test: $result1")
}