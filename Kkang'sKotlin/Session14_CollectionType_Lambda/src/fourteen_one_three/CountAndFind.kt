package fourteen_one_three

class User(val name: String, val age: Int){

}

var list = listOf(User("kknag", 33), User("lee", 28))

fun main() {
    println("count test: ${list.count{it.age > 25}}")

    val user = list.find{it.age > 25}
    println("find test: ${user?.name} ${user?.age}")
}