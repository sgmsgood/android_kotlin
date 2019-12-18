package com.elen.formosa.four_one_one

//변수 선언
val date1: Int = 10
val date2 = 20 //타입추론
var date3 = 30 //변수

fun main(args: Array<String>){
    //date2 = 40 -> 에러 (immutable)
    date3 = 40
}