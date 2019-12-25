package fifteen_one_two

var data1: String = "kkang"
var data2: String? = null

fun myFun(arg: String?){

}

fun main() {
//    data1 = null -> 에러: 프로퍼티를 선언할 때 타입 뒤에 물음표를 추가하지 않으면 Null을 대입할 수 없습니다.
    data2 = "hello"

    val data3: String? = data1
    val data4: String? = data2
    myFun(data4)
}