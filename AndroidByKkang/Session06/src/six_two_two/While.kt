package six_two_two

fun main(args: Array<String>) {
    var x = 0
    var sum1 = 0
    while(x < 10){
        sum1 += ++x
    }

    println(sum1)
}