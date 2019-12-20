package thirteen_one_two

fun hoFun_1(no: Int, argFun1: (Int) -> Int, argFun2: (Int) -> Boolean){

}

fun some(x1: Int = 10){
    println(x1)
}

fun main() {
    hoFun_1 (10, {it * it}, {it > 10})
    hoFun_1 (10, {it * it}) {it > 10}
//    hoFun_1 (10){it * it} {it > 10}

    some()
}