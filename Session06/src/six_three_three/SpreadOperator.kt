package six_three_three

import java.util.Arrays.asList

val array1 = arrayOf(10, 20, 30)

val list2 = asList(1, 2, *array1, 100, 200)

//vararg를 이용한 개발자가 직접 정의한 함수를 이용한 전개 연산자

fun some(vararg a: String){
    val iterator = a.iterator()
    while(iterator.hasNext()){
        println(iterator.next())
    }
}

fun main() {
    list2.forEach({ println(it) })

    val array3 = arrayOf<String>("hello", "world")
    some(*array3)

    val list3 = listOf<String>("a", "b")
    some(*list3.toTypedArray())
}
