package four_one_three

/* Null변수와 Null처리 = ?
* - 변수를 선언할 때 초기에 null을 대입하고 이후 적절한 곳에서 값을 대입하고자 한다면,
*   ?를 사용하여 null이 될 수 있음을 명시하고, 변수 변경을 허용하기 위해 var로 선언해야 합니다. */

//val nonNullData: String = null
val nullableData1: String? = null
var nullableData2: String? = null

fun main(args: Array<String>){
//    nullableNullData1 = "hello"
    nullableData2 = "Nihao"
}