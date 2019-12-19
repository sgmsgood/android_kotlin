package twelve_two_two

fun myFun(x1: Int, x2: Int): Boolean {
    return x1 > x2
}

val lambdaFun: (Int) -> Int = { x: Int -> x * 10 }

val lambdaMyfun: (Int, Int) -> Boolean = { x: Int, y: Int -> x > y }

typealias MyType = (Int) -> Boolean

val myFun: MyType = {it > 10}

fun main() {
    println(lambdaMyfun(10, 20))
}
