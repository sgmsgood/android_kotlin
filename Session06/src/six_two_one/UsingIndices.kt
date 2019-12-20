package six_two_one

fun main() {
    val list = listOf("Hello", "World", "!")

    for(i in list.indices){
        println(list[i])
    }

    for((index, value) in list.withIndex()){
        println("the element at $index is $value")
    }
}

