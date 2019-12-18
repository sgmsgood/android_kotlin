package four_one_three
/* 상수변수 vs val
*  - 둘의 개념은 같지 않습니다.
*  - 두 개 모두 처음의 초기값을 변경하지 않는다는 점 같다고 볼 수 있지만,
*    기본적으로 코틀린에서 변수는 '프로퍼티'의 개념으로서 초기값의 변동이 가능하다는 것을 명심해야 합니다.
*  - 아래에서는 val로 선언한 초깃값이 변동되는 것을 확인할 수 있습니다.
* */
//var myBool = false
//val myVal: String = "hello"
//    get() {
//        if(myBool){
//            return field
//        } else {
//            return field.toUpperCase()
//        }
//    }



/* const
*  - 변수를 최상위 레벨로 선언할 때만 const 예약어를 사용할 수 있게 강제하는게 좋습니다.
*  - 값을 변경할 수 없어서 클래스의 객체별로 데이터를 다르게 표현할 수도 있는데, 굳이 클래스 내부에 선언할 필요가 없는 것입니다. */

const val myConst: Int = 10
//const var myConst2: Int = 10 -> 에러: const를 var 선언 불가능

class MyClass{
//    const val myConst3 = 30
}

fun some(){
//    const val myConst4 = 40
}


fun main(agrs: Array<String>){
    // val 변수 초깃값 변화
//    println(myVal)
//    myBool = true
//    println(myVal)

    // const
}