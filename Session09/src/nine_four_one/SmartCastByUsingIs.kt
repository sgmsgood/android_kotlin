package nine_four_one

class MyClass1{
   fun fun1(){
       println("fun1()...")
   }
}

class MyClass2{
    fun fun2() {
        println("fun2()...")
    }
}
fun smartCast2(obj: Any){
    if(obj is MyClass1){
        obj.fun1()
    } else if (obj is MyClass2) {
        obj.fun2()
    }
}

fun main() {
    smartCast2(MyClass1())
    smartCast2(MyClass2())
}