package five_one_one

/*숫자 타입
* - 데이터 타입을 명시할 때 다른 언어에서처럼 기초 타입이 없습니다.
* - 코틀린의 Int, Double 등은 클래스이며 이 클래스로 타입을 명시하여 선언한 변수는 그 자체로 객체가 됩니다.
**/
val intData: Int = 10
val result = intData.minus(5)

/* 코틀린에서 문자는 숫자 타입이 아니며,
*  숫자타입에 대한 자동 형 변환을 제공하지 않습니다.
*  숫자 타입에 값을 대입할 때는 다음과 같은 규칙이 있습니다.*/
val a3: Byte = 0b00001011 //11
val a4: Int = 123
val a5: Int = 0x0F //15
val a6: Long = 10L //10
val a7: Double = 10.0 //10.0
val a8: Double = 123.5e10 // 1.235E12
val a9: Float = 10.0f //10.0

/* 숫자 타입에 대입되는 데이터에 밑줄을 추가할 수 있습니다
*  가독성을 위한 표현식이며 값에는 영향을 주지 않습니다. */
val oneMillion: Int = 1_000_000

fun main() {
    println(result)

    println(a3)
    println(a4)
    println(a5)
    println(a6)
    println(a7)
    println(a8)
    println(a9)

    println(oneMillion)

}