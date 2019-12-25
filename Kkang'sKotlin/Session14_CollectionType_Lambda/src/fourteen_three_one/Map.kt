package fourteen_three_one

val list2 = listOf<Int>(12, 8, 9, 20)

fun main() {
    list2.filter{ it > 10 }.map{it * 10}.forEach { println(it) }
}