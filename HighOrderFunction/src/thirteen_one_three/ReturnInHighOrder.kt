package thirteen_one_three

fun hoFun5(str: String): (x1: Int, x2: Int) -> Int{
    when (str){
        "-" -> return {x1, x2 -> x1 - x2}
        "*" -> return {x1, x2 -> x1 * x2}
        "/" -> return {x1, x2 -> x1 / x2}
        else -> return {x1, x2 -> x1 + x2}
    }
}

fun main(args:Array<String>) {
    val resultFun = hoFun5("*")
    println("result *: ${resultFun(10, 5)}")
}