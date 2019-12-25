package eight_one_three

var myVal: String = "hello"
    get() = field.toUpperCase()
    set(value){
        field = "hello" + value
    }

class User1(val name: String){
    //클래스 멤버 변수
    var age: Int = 0
        set(value){
            if( value > 0 ) {
                field = value
            } else {
                field = 0
            }
        }

    fun myFun(){
        //함수의 지역변수
        var no = 0
//            get() = field * 0 -> 에러: 지역변수는 프로퍼티가 아닙니다.
    }
}

//주 생성자의 변수를 프로퍼티로 변환하는 방법입니다.
//클래스 내부에서 변수를 선언해서 생성자의 매개변수를 받아줍니다.
// 클래스의 초기 변수이므로 생성자에서 받는 값을 프로퍼티로 재생성할 수 있습니다.
//다만 생성자에 val, var이 있을 경우 아래와 같이 외부에서 값을 변경할 수 있으므로 생성자에 매개변수에는 제거해줍니다.

class User2(var name: String){
    var myName: String = name
        get() = field.toUpperCase()
        set(value){
            field = "Hello" + value
        }
}

class User3(var name: String){
    var myName3: String = name
        get() = field.toUpperCase()
        set(value){
            field = "Hello" + value
        }
}



fun main() {
    val user1 = User1("kkang")
    println("name: ${user1.name}")

    val user2 = User2("kkang")
    user2.name = "lee"
    user2.myName = "kim"
    println("name: ${user2.name}")
    println("myName: ${user2.name}")

    val user3 = User2("lulu")
//    user.name = "elena" -> 생성자의 매개변수에 접근할 수 없음. (생성자의 매개변수에 val, var 제거완료)
    user3.name = "kim"
    println("name: ${user3.name}")
}