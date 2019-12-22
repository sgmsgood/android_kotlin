package nine_five_two

open class Super{
    val publicData: Int = 10
    protected val protectedData: Int = 10
    private val privateData: Int = 10
}

class Sub: Super(){
    fun visibilityTest(){
        println("$publicData..")
        println("$protectedData")
//        println("$privateData")  상위 클래스에서 private로 선언한 변수에 접근하려면 에러가 발생합니다.
//                                  클래스의 멤버들을 private로 선언하면 상속 관계에 의해 하위 클래스에 상속이 안됩니다.
//
    }
}

class SomeClass{
    fun viibilityTest(){
        val obj = Super()
        println("${obj.publicData}")
//        println("${obj.protectedData}") //상위 클래스와는 관련없는 클래스 안에서 protected로 선언된 변수 접근 불가능
//        println("${obj.privateData}")
    }
}