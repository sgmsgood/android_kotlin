package four_two_five
var b = ""
fun <T> varargsFun(a1: Int, vararg array: T){
    for(a in array) {
        println(a)
//        b = array.get(0).toString()
    }
}

fun main(args: Array<String>){
    varargsFun(10, "hello", "world")
    varargsFun(10, 20, false)

    println(b)
}