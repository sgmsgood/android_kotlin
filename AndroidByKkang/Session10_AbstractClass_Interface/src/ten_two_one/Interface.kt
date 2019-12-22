package ten_two_one

interface MyInterface {
    var data1: String
    fun myFun1(){

    }

    fun myFun2()
}

class MyClass: MyInterface{
    override var data1: String = "Hello"
    override fun myFun2(){}
}

fun main() {
//    val obj = MyInterface()-> 인터페이스는 객체로 생성할 수 없습니다.
    val obj1 = MyClass()

    obj1.myFun1()
    obj1.myFun2()
}