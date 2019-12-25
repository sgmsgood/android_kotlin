package four_two_six

tailrec fun sum(n: Int): Int{
    if(n <= 0) return n + sum(n - 1)
    else return n + sum(n - 1)
}

tailrec fun sum2(n: Int, result: Int = 0): Int{
    if(n <= 0) return result
    else return sum2 (n - 1, n + result)
}

fun main(args: Array<String>) {
    println(sum(3))
    println(sum2(3))
}