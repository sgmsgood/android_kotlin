package fourteen_one_one

val list2 = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

fun main() {
//    for (i in resultList2) {
//        println(i)
//    }
    val resultList2 = list2.filter { it < 10 }.forEach { println(it) }

//    println(resultList2.forEach{println(it)})
}

