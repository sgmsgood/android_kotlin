package eight_two_two

class User{
    val name1: String = "kkang"
//    var name2: String = null -> 에러: 멤버변수에 null을 초기화해주고 싶으면, 데이터 타입에 ?를 붙혀줘야 합니다.
    val name3: String? = null
    var age: Int? = null

    constructor(name2: String, name3: String, age: Int){
//        this.name3 = name3 -> 에러
        this.age = age
    }
}