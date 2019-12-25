package fourteen_two_one

val map2 = mapOf<String, Int>("one" to 15, "two" to 5)
val resultMap2 = map2.filter{entry -> entry.value > 10}

fun main() {
    for(i in resultMap2){
        println(i)
    }
}