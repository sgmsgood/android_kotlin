import java.lang.Exception

/*Unit
* - 함수의 반환 구문이 없다는 것을 표현하기 위해 사용됩니다.
* - 자바의 void와 같습니다.*/


//아래의 두 함수는 같은 함수를 선언했습니다.
fun myFun1(){}
fun myFun2(): Unit{}

/*Noting
* - 의미 있는 데이터가 없다는 것을 명시적으로 선언하기 위해 사용하는 타입입니다.
* */

fun myFun(arg: Nothing?): Nothing{
    throw Exception()
}