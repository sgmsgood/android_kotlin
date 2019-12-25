package four_two_two

fun some(who: String){
    println("some(a: $who) call...")
}
fun some(many: Int){
    println("some(a: $many) call...")
}

fun some(a: Int, b: String){
    println("some(a: Int, b: String) call...")
}

fun main(args: Array<String>){
    some("hello")
    some(10)
    some(10, "hello")
}