package fourteen_one_four

/*reduce()는 fold()함수와 비슷하지만, 초기화 값을 지정해주는 곳이 없습니다.
* 그러므로 컬렉션에 값이 없는 경우 런타임 에러가 발생하게 됩니다. 이런 경우에는 fold 함수를 이용해주어야 합니다.*/

val result4 = listOf(1, 2, 3).reduce { sum, next ->
    sum + next
}

fun main() {
    println("reduce test: $result")
}
