package twelve_one_three

val dataVal = 10

//val funVal = fun someFun(){
//}

/* 함수를 변수에 대입하는 방법 (Lambda)
* - 함수를 변수에 대입하려면 람다 함수를 이용하거나 함수 참조를 이용해야 합니다.*/

// 람다 함수를 이용한 방법
val funVal1 = { x1: Int ->
    println("hello world")
    x1 * 10
}

// 참조 변수를 이용한 방
fun someFun(){
    println("i am some Function")
}

val funVal2 = ::someFun

///////////////////////////////

fun sum(x1: Int, x2: Int): Int{
    return x1 + x2
}

val lambdaSum = {x1: Int, x2: Int -> x1 + x2}

val sum2 = { -> 10 + 20}

val sum3 = {10 + 20}

val sum4 = {x1:Int, x2: Int ->
    println("call sum4().....")
    x1 + x2
}

fun main() {
    funVal1(10)
    println(funVal1.toString())

    funVal2()

    println(sum(10, 20))

    println(lambdaSum(10, 20))

    sum4
    sum4(10, 40)
    println(sum4(10, 100))
}
