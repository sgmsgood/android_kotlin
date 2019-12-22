package ten_two_one_three

interface MyInterface6{
    fun myFun6()
}

interface MyInterface7{
    fun myFun7()
}

open class Super{

}

class Sub: Super(), MyInterface6, MyInterface7{
    override fun myFun6() {

    }
    override fun myFun7() {

    }
}