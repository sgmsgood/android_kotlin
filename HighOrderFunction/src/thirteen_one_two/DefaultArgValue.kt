package thirteen_one_two

fun hoFun2(x1: Int,
           argFun1: (Int) -> Int,
           argFun2: (Int) -> Boolean = {x: Int -> x > 10}){
    val result = argFun1(x1)

    println("result: ${argFun2(result)}")
}

fun main() {
    hoFun2(2, {x: Int -> x * x}, {x: Int -> x > 20})
    hoFun2(4, {x: Int -> x * x})
}