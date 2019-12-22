package nine_one_one

/*Any 클래스
* - Any 클래스는 equals(), toString() 이외의 다른 멤버들은 제공하지 않습니다.*/

class Shape{
    var x: Int = 0
    var y: Int = 0
    var name: String = "Rect"

    fun draw(){
        println("draw $name: location: $x, $y")
    }
}

fun main() {
    val obj1: Any = Shape()
    val obj2: Any = Shape()
    val obj3 = obj1

    println("obj1.equals(obj2) is ${obj1.equals(obj2)}")
    println("obj1.equals(obj3) is ${obj1.equals(obj3)}")
}

