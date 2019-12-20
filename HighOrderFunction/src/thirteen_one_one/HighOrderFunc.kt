package thirteen_one_one

//일반 함수 선언
fun normalFun(x1: Int, x2: Int): Int{
    return x1 + x2
}

/* 고차함수
* - 매개변수와 반환에 함수를 이용할 수 있습니다.
* - 매개변수로 함수를 전달받거나 함수를 반환하면 해당 함수를 고차 함수라고 합니다.*/

fun hoFun(x1: Int, argFun:(Int) -> Int){
    val result = argFun(10)
    println("x1: $x1, someFun1: $result")
}

fun main() {
    hoFun(10, {x -> x * x})
}