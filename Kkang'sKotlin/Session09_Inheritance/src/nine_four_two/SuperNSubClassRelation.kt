package nine_four_two

/* 상속 관계에 있는 객체를 명시적으로 캐스팅할 때 as를 이용합니다.
* as를 이용한 캐스팅은 상속 관계에 있는 클래스끼리만 가능하며,
* '하위 타입 -> 상위 타입 -> 하위 타입'으로 변환할 때만 정상적으로 캐스팅됩니다.*/

open class Super{
    fun superFun(){
        println("superFun()...")
    }
}

class Sub1: Super(){
    fun subFun1(){
        println("subFun1()....")
    }
}

class Sub2: Super(){
    fun subFun2(){
        println("subFun2()....")
    }
}

fun main() {
    val obj3: Super = Sub2()
    val obj4: Sub2 = obj3 as Sub2
    obj4.superFun()
    obj4.subFun2()
}