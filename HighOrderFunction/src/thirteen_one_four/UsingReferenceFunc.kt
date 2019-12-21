package thirteen_one_four

import thirteen_one_one.hoFun

fun hoFun6(argFun: (x: Int) -> Int) {
    println("${argFun(10)}")
}

val hoFun7 = { x: Int -> x + 10 }

typealias typeArg = (x: Int) -> Int

fun hoFun8(typeArg: typeArg): Int {
    return typeArg(15)
}

fun hoFun9(argFun: (x: Int) -> Int) {
    println("${argFun(10)}")
}

fun nameFun(x: Int): Int {
    return x * 5
}

fun main() {
    hoFun6 { it * 5 }

    val result = if (hoFun8(hoFun7) == 25) {
        "result is ${hoFun8(hoFun7)}. true"
    } else {
        "false"
    }

    println(result)

    println("Reference Func: ${hoFun6(::nameFun)}")
}
