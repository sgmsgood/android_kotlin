package six_two_three

fun main(args: Array<String>) {
    var x2 = 0
    var sum2 = 0

    while(true){
        sum2 += ++x2
        if(x2 == 10){
            break
        }
    }
    println(sum2)
}