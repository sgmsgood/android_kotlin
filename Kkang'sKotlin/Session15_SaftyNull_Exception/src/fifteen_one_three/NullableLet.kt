package fifteen_one_three

fun main() {
    val array = arrayOf("hello", null, "kkang")

    array.forEach {
        if(it != null){
            println("$it .. ${it.length}")
        }
    }

    array.forEach {
        it?.let{
            println("$it..${it.length}")
        }
    }
}