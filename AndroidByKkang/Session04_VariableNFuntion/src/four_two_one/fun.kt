package four_two_one

// 코틀린에서는 함수 내에 함수를 정의할 수도 있습니다.

fun sum(a: Int, b: Int): Int{
    var sum = 0
    fun calSum(){
        for(i in a..b){
            sum += i // 1+2+3+4+5+6+7+8+9+10 = 55
            sum += 1 // 55 + 1 -> 56 + 1 ... -> 64 + 1 = 65
        }
    }
    calSum()
    return sum
}

fun some(a: Int, b: Int): Int = a + b
val resultOne = some(1, 5)


fun main(args: Array<String>){
    val result = sum(1, 10)
    println(result)

    println(resultOne)
//    calSum() -> 에러

}