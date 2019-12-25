package ten_one_one

/* 추상 함수
    - 미완성 함수 또는 실행 영역이 없는 함수를 의미합니다.
    - 즉, 추상함수를 포함하는 크래스를 의미합니다. 클래스에 포함된 함수 중에 추상 함수가 있으면 이 클래스는 추상 클래스입니다.
 */


// - abstract로 선언한 추상 함수를 포함하는 클래스는 꼭 클래스 선언 부분에 abstract 예약어가 있어야 합니다.
// - abstract 예약어는 클래스 내부에 선언된 함수에만 사용할 수 있으며, 최상위 레벨에 선언된 함수에는 사용할 수 없습니다.
//   즉. 추상형 함수는 객체지향에서 상속과 관련이 있어서 클래스 내부에서만 사용할 수 있는 것입니다.

abstract class AbstarctTest1 {
    fun myFun1(){

    }

    // 추상 함수는 반드시 함수 선언 부분에 abstract 예약어가 있어야 합니다.
    abstract fun myFun2()
}

/*추상 프로퍼티
 - 코틀린에서는 추상 함수와 추상 클래스 뿐만 아니라 프로퍼티도 추상형으로 만들 수 있습니다.
   추상 프로퍼티는 선언부만 있는 프로퍼티를 말합니다.
*/
abstract class AbstractTest2{
    val data1: String = "kkang"

    //이렇게 초깃값없이 선언만 있는 프로퍼티를 추상 프로퍼티라 부르며, 선언부에 abstract 키워드를 추가해야 합니다.
    abstract val data2: String
}