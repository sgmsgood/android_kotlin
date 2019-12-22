package six_one_two

/* when에 분기 조건을 정수, 문자열 등 서로 다른 타입의 데이터로 지정하거나,
*  아니면 Int, String 등으로 데이터 타입 자체를 지정할 수 있습니다.
*  when을 이런 식으로 사용하려면 when에 지정하는 인수는 Any 타입이어야 합니다. */

fun testWhen(data: Any){
    when(data){
        1 -> println("data value is 1")
        "hello" -> println("data value is hello")
        is Boolean -> println("data type is Boolean")
    }
}