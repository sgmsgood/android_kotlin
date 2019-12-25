package nineteen_one_one_one

interface Print{
    fun print(arg: String)
}

class MyDelegatee: Print{
    override fun print(arg: String){
        println("i am delegatee: $arg")
    }
}

class MyDelegator(obj: MyDelegatee): Print by obj

fun main() {
    val obj: MyDelegatee = MyDelegatee()
    MyDelegator(obj).print("hello kkang")
}