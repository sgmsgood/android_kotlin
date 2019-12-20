package six_one_one

/* 코틀린에서 if문은 표현식입니다.
   - 이것은 if문에 의해 특정 값이 발생한다는 의미입니다.
   - if를 표현식으로 사용할 때 주의할 점은 else문이 꼭 있어야 한다는 점입니다.
     생략 시, 컴파일 에러가 발생합니다. */

val a = 5

val result2 = if (a < 10) {
    print("hello...")
    10 + 20
} else {
    print("world...")
    20 + 20
}

val result3 = if (a > 10) {
    20
} else {
    30
}

/* 표현식?
 - 변수, 상수, 연산자, 함수로 구성되어 무언가 값을 만드는 문장을 의미하며,
   구문이란 특정 단어나 기호의 조합으로 무언가가 실행되도록 명령을 지시하는 문장을 의미합니다.
 - 즉, 어떤 문장이 결괏값을 만드는지 아닌지의 차이입니다.
 - 표현식은 새로운 값을 만드는 것이어서 대입 연산자(=) 오른쪽에 명시할 수 있거나 함수의 매개변수에 대입할 수 있습니다.
 */

val count = 10
val expression = if(count > 5){
    "true"
} else {
    "false"
}

fun some(a: String): String {
    return a
}

fun main(args: Array<String>) {
//
//    if (a < 10) println("$a < 10")
//
//    // if-else
//    if (a > 0 && a <= 10) {
//        println("0 < $a <= 10")
//    } else if (a > 10 && a <= 20) {
//        println("10 < $a <= 20")
//    } else {
//        println("$a > 20")
//    }

    print(result2)

    println("")

    if(some(expression) == "true"){
        println("his words are $expression")
    } else {
        println("his words are $expression")
    }
}