package four_one_two

/*코틀린 변수 선언:
* - 최상위(클래스 외부), 클래스 내부, 함수 내부에 가능합니다.
* - 자동으로 초기화되지 않으므로 코드에서 직접 초기화해야만 사용이 가능합니다.
* ('함수 내부'에서는 변수 선언 시에 초기값을 입력하지 않아도 에러가 뜨지 않습니다. 단, 사용할 수는 없습니다.)
**/

//val topData1: Int -> 에러
//val topData2: Int -> 에러

val topData1: Int = 10
val topData2: Int = 20

class InitVariable {
//    val objData1: String -> 에러
//    val objData2: String -> 에러
    val objData1: String = "Taiwan"
    val objData2: String = "Jasper.Ryu"

    fun some(){
        val localData1: Int
        val localData2: String

//        println(localData1)

        localData2 = "hello"
        println(localData2)
    }
}