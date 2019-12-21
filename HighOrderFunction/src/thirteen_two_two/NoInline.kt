package thirteen_two_two

inline fun inlineTest(argFun1: (x: Int) -> Int, noinline argFun2: (x: Int) -> Int){
    argFun1(10)
    argFun2(10)
}

fun main() {
    inlineTest({it * 10}, {it * 20})
}