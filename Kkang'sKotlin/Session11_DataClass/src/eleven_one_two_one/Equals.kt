package eleven_one_two_one

/* 데이터 클래스가 유용한 것은 데이터 클래스에 선언한 데이터와 관련된 다양한 기능을 함수로 제공하기 때문입니다.

* - equals() / hashCode()
* - toString()
* - componentN()
* - copy() */

/* equals()
* - 아래의 두 클래스는 모두 주 생성자만 선언합니다. 즉, 데이터만을 목적으로 하는 클래스입니다.
* - product는 일반 클래스이고, User는 data 예약어를 사용한 데이터 클래스입니다. */

class Product(val name: String, val price: Int)

data class User(val name: String, val age: Int)

/* main에서 두 클래스의 차이점을 확인할 수 있습니다.
*  - product.equals(product1) = false 입니다.
*  - equals()는 객체를 비교하는 함수이지, 객체의 데이터를 비교하지 않습니다.
*  - 따라서 product와 product1은 각각 생성된 객체이므로 다른 객체입니다.
*
*  - 클래스를 data로 선언하면 데이터 클래스의 equals()함수는 객체를 비교하지 않고 객체의 데이터를 비교합니다.
*  - 따라서 두 객체의 데이터는 같으므로 true를 반환합니다.
*  - 같은 데이터 클래스만 비교합니다! equals는 다른 클래스의 데이터를 비교하지는 않습니다.
*    (다른 데이터 클래스 비교 eleven_one_two_two) */

fun main() {
    var product = Product("kkang", 30)
    var product1 = Product("prod1", 100)
    println(product.equals(product1))

    var user = User("kkang", 30)
    var user1 = User("kkang", 30)
    println(user.equals(user1))

    println("equals() in different Class: ${product.equals(user)}")
}
