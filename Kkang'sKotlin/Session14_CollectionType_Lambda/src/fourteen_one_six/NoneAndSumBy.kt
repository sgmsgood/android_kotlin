package fourteen_one_six

/* none() 함수는 람다 함수에서 지정한 조건에 맞는 데이터가 없으면 true, 있으면 false를 반환합니다.
* all(), any()와 비교해보세요. */
val result2 = listOf(1, 11, 5).none{it % 10 == 0}

/* sumBy() 함수는 람다 함수를 거쳐 반환한 모든 값을 더하는 함수입니다.*/
var result3 = listOf(1, 2, 3).sumBy {it * 10}

fun main() {
    println("none test: $result2")
    println("sumBy test: $result3")
}