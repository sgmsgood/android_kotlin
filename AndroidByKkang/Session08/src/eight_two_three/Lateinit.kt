package eight_two_three

class User1{
    lateinit var lateData: String
}

lateinit var data1: String

//class User2(lateinit var data: String){ // -> **에러: 주 생성자에 추가해서 불가능
//    lateinit val data2: String  -> 에러: lateinit은 val 변수에서 사용 불가능
//    lateinit var data3: String? -> **에러: lateinit은 null을 허용으로 선언한 프로프티에 추가해서 불가능
//    lateinit var data4: Int -> **에러: 기초 타입인 Int로 선언한 프로퍼티에 lateinit를 추가해서 에러 발생.
//}

fun main() {
    //lateinit
    val user = User1()
    user.lateData = "hello"
    println(user.lateData)
}