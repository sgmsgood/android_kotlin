package fourteen_one_five

/* max()는 컬렉션 타입의 데이터 중 가장 큰 값을 반환합니다. */
var result1: Int? = listOf(1, 11, 5).max()

/* maxBy()는 최댓값을 반환한다는 점에서 max()함수와 목적은 같지만,
* 람다 함수를 매개변수로 지정하여 로직에 의한 계산 결과 중 가장 큰 수를 반환해줍니다.*/
var result2 = listOf(1, 11, 5).maxBy { it % 10}

fun main() {
    println("max test: $result1")
    println("maxBy test: $result2")
}