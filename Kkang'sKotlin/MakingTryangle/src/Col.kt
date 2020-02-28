fun main() {
    col(1)
}

fun col(a: Int) {
    var result: Int
    var value = a

    while (value >= 1) {
        println(value)

        if (value % 2 == 0) {
            result = value / 2
        } else {
            result = value / 3
        }
        value = result
    }
}