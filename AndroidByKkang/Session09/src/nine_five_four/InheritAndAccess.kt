package nine_five_four

/* open으로 선언한 함수와 프로퍼티에 private 접근 지정자를 지정할 수 없습니다. */

open class Super1{
  /*  open private fun myFun1(){

    } -> open과 private는 동시에 선언 불가능*/

    open fun myFun2(){

    }

    open protected fun myFun3(){

    }
}

class Sub1: Super1(){
    /*override private fun myFun2(){

    } -> 하위 클래스가 상위 클래스를 오버라이드 받을 때 접근 번위를 축소할 수는 없습니다.*/

    override fun myFun3(){

    }
}