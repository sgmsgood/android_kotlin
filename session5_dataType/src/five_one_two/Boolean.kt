package five_one_two
/*논리 타입
*  || -> 논리합
*  && -> 논리곱
*  ! -> 부정 */
val isTrue1: Boolean = true && false
val isTrue2: Boolean = true||false
val isTrue3: Boolean = !true

fun main() {
    println(isTrue1) // false
    println(isTrue2) // true
    println(isTrue3) // false
}