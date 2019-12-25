package fourteen_two_one

val list2 = listOf<Int>(12, 8, 9, 20)
val resultList = ArrayList<Int>()

fun main() {
    for(i in list2){
        if(i > 10) resultList.add(i)
    }

    for(i in resultList){
        println(i)
    }
}