package nine_four_one

fun smartCast(data: Any): Int{
    if(data is Int){
        return data * data
    } else {
        return 0
    }
}

fun main() {
    println("result: ${smartCast(10)}")
    println("result: ${smartCast(10.0)}")
}