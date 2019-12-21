package thirteen_one_four

val lambdasFun = { x: Int ->
    println("i am lambdas function")
    x * 10 //기존 람다식에서 마지막 줄이 return 값 (return 사용 X)
}

val anonyFun1 = fun(x: Int): Int = x * 10

// 일반 함수 선언에 함수명만 정의하지 않은 함수

val anonyFun2 = fun(x: Int): Int {
    println("i am anonymous function")
    return x * 10 //
}

//val func1 : (abc: (x: Int) -> Int) = {
//    x * 10
//}

fun main() {
    println(anonyFun2(123))
}
