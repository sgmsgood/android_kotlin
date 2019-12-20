package five_two_two

val immutableList: List<String> = listOf("hello", "world")
val mutableList: MutableList<String> = mutableListOf("hello", "world")

val arrayList: ArrayList<String> = ArrayList()

fun main() {
    println("${immutableList.get(0)}..${immutableList.get(1)}")

    mutableList.add("kkang")
    mutableList.set(1, "korea")
    println("${mutableList.get(0)}..${mutableList.get(1)}..${mutableList.get(2)}")

    arrayList.add("hello")
    arrayList.add("kkang")
    arrayList.set(1, "world")
    println("${arrayList.get(0)}..${arrayList.get(1)}")
}