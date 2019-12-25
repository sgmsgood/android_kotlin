package fifteen_one_three

fun main() {
    var data1: String? = "kkang"
    val length: Int? = data1?.length


    val length1: Int? = if(data1 != null){
        data1.length
    } else {
        null
    }
}
