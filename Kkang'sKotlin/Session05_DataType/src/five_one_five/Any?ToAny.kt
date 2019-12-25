package five_one_five

/* 클래스의 타입을 고려한다면, Any? 타입이 코틀린의 최상위 타입입니다.
*  Any? <- Any는 대입이 가능하지만, Any <- Any?는 불가능합니다.*/

val myVal1: Any = 10
val myVal2: Any? = myVal1

val myVal3: Any? = 10
//val myVal4: Any = myVal3 // Any <- Any? 대입이 불가능합니다.
val myVal5: Any = myVal3 as Any // Any?를 Any로 캐스팅 해주면 대입이 가능해집니다.