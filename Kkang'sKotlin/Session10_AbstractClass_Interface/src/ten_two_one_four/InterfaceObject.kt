package ten_two_one_four

interface MyInterface10{
    fun myInterfaceFun()
}

open class Super1{
    fun mySuperFun(){
        println("mSueprFun()...")
    }
}

class Sub1: Super1(), MyInterface10{
    override fun myInterfaceFun(){
        println("myInterfaceFun cal....")
    }
}

fun main() {
    val obj1: Sub1 = Sub1()
    val obj2: Super1 = Sub1()
    val obj3: MyInterface10 = Sub1()

    obj1.mySuperFun()
    obj1.myInterfaceFun()

    //객체의 타입에 따라 그 타입에 선언된 함수만 호출할 수 있습니다.

    obj2.mySuperFun()
//    obj2.myInterfaceFun()

//    obj3.mySuperFun()
    obj3.myInterfaceFun()
}