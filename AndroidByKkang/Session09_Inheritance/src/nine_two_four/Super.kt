package nine_two_four

open class Auper{
    open var x: Int = 10
    open fun someFun(){
        println("Super... someFun()")
    }
}

class Sub: Auper(){
    override var x: Int = 20
    override fun someFun(){
        super.someFun()
        println("Sub... ${super.x}.... $x")
    }
}

fun main() {
    var sub = Sub()
    sub.someFun()
}