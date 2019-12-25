package eleven_one_one

/* Data Class
* - 내부에 특별한 로직의 함수 없이 데이터만 포함할 수 있는 클래스. (자바에서 VO_Value Object)
* - 코틀린에서는 data라는 예약어로 선언하는 클래스입니다.
*
* **데이터 클래스 조건 **
* - 주 생성자를 선언해야 하며 주 생성자의 매개변수는 최소 하나 이상이어야 한다.
* - 모든 주 생성자의 매개변수는 var 혹은 val로 선언해야 한다.
* - 데이터 클래스는 abstract, open, sealed, inner 등의 예약어를 추가할 수 없다. */

//data class User1() -> 매개변수가 없어서 에러

//data class User2(name: String) -> 모든 주 생성자의 매개변수는 var 또는 val 이어야 합니다.

//data abstract class User3(val name: String) -> 데이터 클래스는 abstract 예약어 추가 불가능.

//data class User4 (val name: String, no: Int) -> data의 모든 매개변수는 var 또는 val로 선언해야 합니다.