package nine_two_three

open class Super{
    open val name: String = "kkang"
    open var age: Int = 10
    open val email: String? = null
    open val address: String = "seoul"
}

open class Sub: Super(){
    final override var name: String ="kim"
//    override val age: Int = 20 // var -> var 가능, var -> val 불가능
    override val email: String = "a@a.com"
//    override val address: String? = null // null 불허 -> null 허용 불가능
}

class Sub2: Sub(){
//    override var name: String = "Elena" //final로 선언된 변수는 override 불가능
    override var email: String = "lee"
}