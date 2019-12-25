package six_two_one

val list = listOf("Hello", "World", "!")
val sb = StringBuffer()

fun main(args: Array<String>) {
    var sum = 0
    for(i in 1..10){
        sum += i
    }
    println(sum)

    for(str in list){
        sb.append(str)
    }

    println(sb)
}