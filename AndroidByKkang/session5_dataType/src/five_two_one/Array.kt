package five_two_one

import com.sun.xml.internal.fastinfoset.util.StringArray

var array1 = arrayOf(1, "kkang", true)

val arrayInt = arrayOf<Int>(1, 2, 3)


/* 특정 타입의 데이터를 대입하는 배열을 제네릭으로 선언하지 않고 지정된 함수를 이용할 수도 있습니다.
* - 기초 데이터 타입과 관련된 값은 xxxArrayOf() 함수도 제공합니다.
*
* booleanArrayOf()
* byteArrayOf()
* charArrayOf()
* doubleArrayOf()
* floatArrayOf()
* intArrayOf()
* longArrayOf()
* shortArrayOf()
* */

var arrayInt2 = intArrayOf(4, 5, 6)

/* 이 함수들은 Array 클래스 타입의 배열 객체를 반환합니다.
*  따라서, arrayOf() 함수를 이용하지 않고 Array 클래스를 직접 이용하여 배열을 만들 수도 있습니다.
*
* BooleanArrayOf()
* ByteArrayOf()
* CharArrayOf()
* DoubleArrayOf()
* FloatArrayOf()
* IntArrayOf()
* LongArrayOf()
* ShortArrayOf()
* */

var array3 = Array(3, { i -> i * 10 })

var array4 = arrayOfNulls<Any>(3)

var emptyArray = Array<String>(3, {""})

fun main() {
    array1[0] = 10
    array1[2] = "world"

    println("${array1[0]}.. ${array1[1]}..${array1[2]}")
    println("size: ${array1.size}..${array1.get(0)}..${array1.get(1)}.${array1.get(2)}")

    println("${arrayInt.get(0)}..${arrayInt.get(1)}..${arrayInt.get(2)}")

    println("arrayInt2: ${arrayInt2.forEach { it }}")

    println("${array3[0]}..${array3[1]}..${array3[2]}")

    array4[0] = 10
    array4[1] = "hello"
    array4[2] = true
    println("${array4[0]}..${array4[1]}..${array4[2]}")

    emptyArray[0] = "hello"
    emptyArray[1] = "world"
    emptyArray[2] = "kkang"
    println("${emptyArray[0]}..${emptyArray[1]}..${emptyArray[2]}")
}
