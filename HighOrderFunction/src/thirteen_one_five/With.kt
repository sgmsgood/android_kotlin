package thirteen_one_five

class WithUser(name: String, age: Int) {
    var name: String? = name
    var age: Int? = age

//    constructor(name: String, age: Int): this() {
//        this.name = name
//        this.age = age
//    }
}

fun sayHello() {
    println("hahahaha")
}

fun main() {
    val user = WithUser("elena", 30)

    user.run {
        name = "kkang"
        age = 20
        sayHello()
    }

    with(user){
        name = "kkang"
        sayHello()
    }
}