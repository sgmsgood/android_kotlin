package five_two_two

/* mapOf vs mutableMapOf
* - */

val immutableMap1 = mapOf(Pair("one", "hello"), Pair("two", "world"))
val immutableMap2 = mapOf("one" to "hello", "two" to "kkang")

val mutableMap = mutableMapOf<String, String>()

fun main() {
    println("${immutableMap1.get("one")}..${immutableMap1.get("two")}")
    println("${immutableMap2.get("one")}..${immutableMap2.get("two")}")

    mutableMap.put("one", "hello")
    mutableMap.put("two", "map")
    println("${mutableMap.get("one")}..${mutableMap.get("two")}")
}