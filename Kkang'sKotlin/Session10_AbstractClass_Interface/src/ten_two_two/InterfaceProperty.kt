package ten_two_two

/* 인터페이스에서 프로퍼티를 정의할 때의 규칙
*  - 추상형으로 선언하거나, get() set() 함수를 정의해야 한다.
*  - 추상 프로퍼티가 아니라면 val은 get() 함수를 꼭 선언해야 한다.
*  - 추상 프로퍼티가 아니라면 var은 get() set() 함수를 꼭 선언해야 한다.
*  - 인터페이스의 프로퍼티를 위한 get() set() 함수에서는 field를 사용할 수 없다.*/

interface MyInterface8{
    var prop1: Int

//    val prop2: String = "kkang"

    // 인터페이스에 프로퍼티의 get(), set() 함수에서 field를 사용할 수는 없지만, 로직을 추가할 수는 있습니다.
//    val prop2: String
//        get() = field

//    var prop3: String
//        get() = "kkang"

    /* 인터페이스에서는 프로퍼티를 추상으로 선언하지 않으면 반드시 get(), set()으로 함수를 추가해야 합니다.
        아래는 각각 val과 var로 프로퍼티를 선언했는데 추상형으로 선언하지 않아서
        val로 선언한 프로퍼티에는 get() 함수를 정의했고
        var로 선언한 프로퍼티에는 get(), set() 함수를 정의했습니다.
     */

    val prop4: String
        get() = "kkang"

    var prop5: String
        get() = "kkang"
        set(value) {

        }
}

interface MyInterface9{
    var data1: Int

    var data2: Int
        get() = 0
        set(value){
            if(value > 0){
                calData(value)
            }
        }

    val data3: Boolean
        get(){
            if(data1 > 0){
                return true
            } else {
                return false
            }
        }

    private fun calData(arg: Int){
        data1 = arg * arg
    }
}

class MyClass9: MyInterface9{
    override var data1: Int = 0
}

fun main() {
    val obj = MyClass9()
    println("data1: ${obj.data1}, data2: ${obj.data2}, data3: ${obj.data3}")

    obj.data2 = 5
    println("data1: ${obj.data1}, data2: ${obj.data2}, data3: ${obj.data3}")
}