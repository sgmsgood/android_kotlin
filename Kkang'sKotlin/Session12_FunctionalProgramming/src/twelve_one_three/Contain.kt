package twelve_one_three

// 코틀린 함수 내에는 변수, 함수 및 클래스를 선언할 수 있습니다.

fun superFun(){
    val superData = "hello"

    fun subFun1(){
        println("subFun()..superData: ${superData}")
    }
    fun subFun2(a: Int, b: Int): Int{
        subFun1()
        return a + b
    }

    class SubClass{
        fun classFun(){
            println("classFun()..superData: ${superData}")
        }
    }

    subFun1()
    SubClass().classFun()
}

fun main() {
    superFun()
}