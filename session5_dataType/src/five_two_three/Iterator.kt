package five_two_three

fun main() {
    //iterator - list
    val list1 = listOf<String>("hello", "list")
    val iterator1 = list1.iterator()
    while(iterator1.hasNext()){
        println(iterator1.next())
    }

    //iterator - map
    val map = mapOf<String, String>("one" to "hello", "two" to "map")
    val iterator2: Iterator<Map.Entry<String, String>> = map.iterator()
    while(iterator2.hasNext()){
        val entry = iterator2.next()
        println("${entry.key} - ${entry.value}")
    }

    //iterator - set
    val set = setOf<String>("hello", "set")
    val iterator3 = set.iterator()
    while(iterator3.hasNext()){
        println("${iterator3.next()}")
    }

    val array = arrayOf("hello", "world")
    val iterator4 = array.iterator()
    while(iterator4.hasNext()){
        println("${iterator4.next()}")
    }
}