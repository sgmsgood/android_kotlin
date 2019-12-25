package fifteen_one_four

fun main() {
    var data: String? = "kkang"

    var length: Int = if(data != null){
        data.length
    } else {
        -1
    }

    data = null
    length = data?.length ?: -1
    println(length)

    data ?: println("data is null")

}