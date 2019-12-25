package eleven_one_two_four

class Product(val name:String, val price: Int)

data class User(val name: String, val age: Int){
    var email: String = "a@a.com"
}

fun main() {
    var product = Product("prod1",100)
    println(product.toString())

    var user = User("kkang", 30)
    println(user.toString())
}