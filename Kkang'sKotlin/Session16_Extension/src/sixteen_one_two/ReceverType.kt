package sixteen_one_two

open class Super{
    open fun superFun(){
        println("Super...superFun...")
    }
}

class Sub: Super(){
   var data: Int = 20
    override fun superFun(){
        println("Sub..superFun...${data}")
    }

    fun some1(data: Int){
        this.data = data
        superFun()
        super.superFun()
    }
}

fun Sub.some2(data: Int){
    this.data = data
    superFun()
//    super.superFun()
}

fun main() {
    val obj: Sub = Sub()
    obj.some1(10)
    obj.some2(100)
}