package sixteen_two_two

class Test{
    companion object{
        val data1: Int = 10
        fun myFun(){
            println("companion object myFun1()...")
        }
    }
}

val Test.Companion.data2: Int
    get() = 20

fun Test.Companion.myFun