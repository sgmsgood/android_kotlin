package five_one_two

fun sum(no: Int): Int{
    var sum = 0
    for(i in 1..no){
        sum += i
    }
    return sum
}

fun main() {
    val name = "kkang"
    println("name: $name.. ${sum(10)}")
}