package fourteen_one_one

fun main() {
    listOf(1,2,4).forEachIndexed {index, value ->
        println("index: $index, value: $value")
    }
}