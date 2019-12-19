package five_one_seven

/* Is
* - 데이터 타입을 판단하는 연산자 */

fun getStringLength(obj: Any): Int?{
//    val strData: String = obj
    if(obj is String){
        return obj.length
    }
    return null
}
/* !is */
fun getStringLength2(obj: Any): Int?{
    if(obj !is String){
        return null
    }
    return obj.length
}

/* 기초 타입의 캐스팅: toXXX()*/

var a1: Int = 10
//var a2: Double = a1 (에러!)

var a3: Double = a1.toDouble()

