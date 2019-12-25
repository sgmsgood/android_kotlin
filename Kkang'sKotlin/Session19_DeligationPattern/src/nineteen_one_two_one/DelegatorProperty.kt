package nineteen_one_two_one

import kotlin.reflect.KProperty

class MySumDelegate{
    var result: Int = 0

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Int{
        println("getValue call... ref: $thisRef, property: '${property.name}'")
        return result
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Int){
        result = 0
        println("setValue call... value: $value, '${property.name}'")
        for(i in 1..value){
            result += i
        }
    }
}

class Test{
    var sum: Int by MySumDelegate()
}

fun main() {
    val obj = Test()
    obj.sum = 10
    println(obj.sum)
    obj.sum = 5
    println(obj.sum)
}