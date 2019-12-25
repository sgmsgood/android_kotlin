package fifteen_one_five

fun main() {
    var data: String? = "kkang"

    data!!.length

    data = null
    data!!.length
}