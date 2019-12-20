package thirteen_one_two

/* 함수 타입의 매개변수 대입
* - 고차 함수의 매개변수가 함수 타입이면 함수 호출 때 ()를 생략할 수 있습니다.*/

fun hoFun1(argFun: (Int) -> Int) {
    val result = argFun(10)
    println("result: $result")
}

val array = arrayOf(10, 20, 15, 22, 8)


fun main() {
    hoFun1({ x -> x * x })
    hoFun1 { x -> x - x }

    array.filter { x -> x > 10 }.forEach { x -> println(x) }

    array.filter { it > 10 }.forEach { println(it) }
}