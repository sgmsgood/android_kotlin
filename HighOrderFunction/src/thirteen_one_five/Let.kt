package thirteen_one_five

class LetUser(){
    var name: String? = null
    var age: Int? = null

    constructor(name: String, age: Int): this(){
        this.name = name
        this.age = age
    }
}

fun letTestFun(user: LetUser){
    println("letTestFun(): ${user.name}..${user.age}")
}

fun main() {
    val user4 = LetUser("kkang", 33)
    letTestFun(user4)

    LetUser("kim", 28).let{
        letTestFun(it)
    }
}