package twelve_one_two

import java.io.File
import java.io.FileWriter
import java.lang.Exception

/*순수 함수
* - 같은 매개변수를 넣으면 항상 같은 결과값을 출력해야 함.*/

fun some(a: Int): Int{
    return (Math.random() * a).toInt() // 항상 다른 값을 출력하므로 순수 함수가 아님.
}

fun some1(a: String): Boolean {
    try {
        val file = File("a.txt")
        val out = FileWriter(file)
        out.write(a)
        out.flush()
        return true
    } catch (e: Exception){
        return false
    }
} // 함수 내부에서 파일 입출력이 발생하므로, 부수효과가 생기게 됨.

//순수 함수
fun some2(a: Int, b: Int): Int{
    return a + b
}

fun some3(): Int{
    return 10
}