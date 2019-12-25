package test_kotlin

import test.JavaInterface1
import test.SAMTest

fun main() {
    val obj = SAMTest()
//    obj.setInterface(object: JavaInterface1{
//        override fun callback(){
//            println("hello kotlin")
//        }
//    })

    obj.setInterface{println("hello sam")}
    obj.callback.callback()
}