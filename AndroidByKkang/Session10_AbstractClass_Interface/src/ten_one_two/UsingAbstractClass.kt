package ten_one_two

/* 추상 클래스는 그 자체로는 객체를 생성할 수 없습니다.
    - 추상 클래스를 상속받는 하위 클래스를 작성하고 하위 클래스의 객체를 생성해서 이용해야 합니다.
    - 추상 클래스를 상속받는 하위 클래스를 정의할 때는 상위 추상 클래스에 정의된 추상 함수와 추상 프로퍼티를 모두 재정의해야하며,
      만약, 그렇지 않다면 하위 클래스도 abstract 키워드를 이용해 추상형으로 선언해야 합니다.
 */

abstract class Super{
    val data1: Int = 10
    abstract val data2: Int

    fun myFun1(){

    }

    abstract fun myFun2()
}

class Sub: Super(){
    override val data2: Int = 10
    override fun myFun2(){

    }
}

fun main() {
    // 추상 클래스는 객체를 생성할 수 없습니다.
    // 즉, 추상 클래스를 정의한다는 것은 하위 클래스를 작성하겠다는 의도입니다.
//    val obj1 = Super()

    val obj2 = Sub()
}