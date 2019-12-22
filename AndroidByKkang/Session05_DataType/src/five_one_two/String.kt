package five_one_two

/* Escaped String
* - 개행 시에 \n을 표기해야 합니다.*/
var str: String = "Hello"

/* Raw String
* - 키보드에 입력한 엔터 등의 값이 문자열에 그대로 적용됩니다.*/
var str2 = """Hello
    Jasper Ryu"""

fun main() {
    println("str[1]: ${str[1]}")

    println("str2: $str2")
}
