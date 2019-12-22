package five_two_two

val immutableSet = setOf<String>("hello", "hello", "world")
val mutableSet = mutableSetOf<String>()


fun main() {
    println("${immutableSet.elementAt(0)}..${immutableSet.elementAt(1)}")

    mutableSet.add("hello")
    mutableSet.add("set")
    println("${mutableSet.elementAt(0)}..${mutableSet.elementAt(1)}")
}