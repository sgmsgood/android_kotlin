package sixteen_two_two

class Test{
    companion object{
        val data1: Int = 10
        fun myFun1(){
            println("companion objext myFun1()...")
        }
    }
}

val Test.Companion.data2: Int
    get() = 20

fun Test.Companion.myFun2(){
    println("extension myFun2()...")
}

fun main() {
    println("data1: ${Test.data1}...data2: ${Test.data2}")
    Test.myFun1()
    Test.myFun2()
}