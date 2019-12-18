package four_two_three

//fun sayHello(name: String?){
//    if(name == null){
//        println("Hello!! kkanng")
//    } else {
//        println("Hello $name")
//    }
//}



fun sayHello(name: String = "Jasper Ryu"){
    println("Nihao $name!!")
}

fun checkPatient(name: String = "JJ", age: Int){
    println("checked name is $name and age is $age")
}

fun checkOnlyName(name: String, age: Int = 100){
    println("I don't mind how old are you. You are $name. right?" )
}

fun main(args: Array<String>) {
//    sayHello(null)
//    sayHello("kim")

    sayHello()
    sayHello("JJlin")

//    checkPatient(10)
    checkOnlyName("JJLin")

    checkPatient("Elen", 20)
    checkPatient(age = 30)
    checkPatient(name = "angela", age = 18)

}