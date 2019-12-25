package fourteen_two_three

fun main() {
    listOf(2,1,12,5,23).dropWhile { it < 10 }.forEach { println(it) }
}