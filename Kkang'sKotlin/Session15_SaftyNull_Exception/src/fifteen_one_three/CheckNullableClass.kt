package fifteen_one_three

class Address{
    val city: String? = "seoul"
}

class User{
    val address: Address? = Address()
}

fun main(){
    val user: User? = User()

    println(user?.address?.city)
}