package nine_five_two

//외부 파일에서는 private로 선언된 프로퍼티에 대한 접근, 함수 호출, 클래스의 객체 생성이 불가능합니다.

val myData1: Int = 10

private val myData2: String = "hello"

class MyClass1(){}

private class MyClass2(){

}

fun myFun1(){
    println("myFUn() call...")
}

private fun myFun2(){
    println("myFun() call...")
}

fun main() {
    //최상위 구성요소에 접근
    println("$myData1")
    println("$myData2...")
    val obj1 = MyClass1()
    val obj2 = MyClass2()
    myFun1()
    myFun2()
}