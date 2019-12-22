package five_one_four

fun parseInt(str: String): Int?{
    return str.toIntOrNull()
}

fun main() {
    parseInt("w")
}