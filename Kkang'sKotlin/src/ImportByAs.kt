import java.util.*
import java.sql.Date as SqlDate

//코틀린에서는 모든 구성요소가 클래스로 묶일 필요는 없다.

/*
* 패키지는 다르지만 클래스명이 DATE로 중복되는 경우
* 'as' 예약어로 이름을 변경해서 임포트하면 쉽게 작성이 가능합니다.
* */
fun main(args: Array<String>) {
//    val date = Date()
//    val date2 = java.sql.Date(System.currentTimeMillis())

    val date = Date()
    val date2 = SqlDate(System.currentTimeMillis())

    println("java.util.Date(): $date")
    println("java.sql.Date(): $date2")
}