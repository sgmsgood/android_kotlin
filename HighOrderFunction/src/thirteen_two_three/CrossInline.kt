package thirteen_two_three

open class TestClass{
    open fun some(){}
}

fun inlineTest3(argFun: () -> Unit){
    val obj = object: TestClass(){
        override fun some() = argFun()
    }
}
