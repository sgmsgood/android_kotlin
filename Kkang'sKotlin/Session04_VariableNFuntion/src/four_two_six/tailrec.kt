package four_two_six

fun loopPrint(no: Int = 1){
    var count = 1
    while(true){
        println("loopPrint")
        if(no == count){
            return
        } else {
            count++
        }
    }
}

fun recPrint(no: Int = 1, count: Int = 1){
    println("recPrint...")
    return if(no == count) return else recPrint(no -1, count)
}


/* tailrec 재귀함수
* - tailrec으로 선언된 함수는 개발자가 재귀함수를 잘못 코딩했을 경우에
*   java에서 발생하는 stackOverFlowError의 부담을 줄여줍니다. */
tailrec fun tailrecPrint(no: Int = 1, count: Int = 1){
    println("tailrecPrint")
    return if(no == count) return else tailrecPrint(no -1, count)
}

fun main(args: Array<String>){
    loopPrint()
    recPrint(3)

    tailrecPrint(3)
}