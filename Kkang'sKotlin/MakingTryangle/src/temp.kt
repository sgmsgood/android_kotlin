fun main() {
//    printInfo ("hi") {
//        val a = it
//        print(a)
//    }

    val list = arrayListOf("abc", "def", "ghi")

    val a = list.get(1)
    val b = list.get(2)

    fun result(abc: (String, String) -> String) {
        val c = list.get(1)
        val d = list.get(2)

        abc
    }

    result(){ a, b -> a + b }
}

fun printInfo(a: String, p: (String) -> Unit) {
    p("${a}? abc: ")
    print("Calculator Version")
}