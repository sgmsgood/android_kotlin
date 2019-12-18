package four_two_four
/* 중위 함수식
* 1. 클래스의 멤버 함수로 선언하거나 클래스의 확장(extension) 함수일 때
* 2. 매개변수가 하나인 함수일 때
* */
infix fun Int.myFun(x: Int): Int{
    return x * x
}

class FunClass{
    infix fun infixFun(a: Int){
        println("infixFun call....")
    }
}

fun main() {
    val obj = FunClass()
    obj.infixFun(20)

    obj infixFun 10

    println(10 myFun 10)
    println(10.myFun(10))
}