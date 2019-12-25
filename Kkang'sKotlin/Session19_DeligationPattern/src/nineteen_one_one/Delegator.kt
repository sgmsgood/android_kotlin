package nineteen_one_one

class MyDelegatee{
    fun print(str: String){
        println("i am delegatee: $str")
    }
}

class MyDelegator{
    val delegatee: MyDelegatee = MyDelegatee()

    fun print(str: String){
        delegatee.print(str)
    }
}

fun main() {
    val obj: MyDelegator = MyDelegator()
    obj.print("hello kkang")
}