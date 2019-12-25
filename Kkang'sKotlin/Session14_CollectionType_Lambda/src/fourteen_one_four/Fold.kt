package fourteen_one_four

/* fold() 함수
* - 컬렉션 타입의 데이터를 람다 함수에 차례로 전달하며 람다 함수의 결괏값을 반환해줍니다.
* - 특징은 람다 함수에서 반환한 값을 기억하고 있다가 그 다음 데이터에 의해 호출될 때 이전에 반환했던 값을 함께 전달해주어 참조할 수 있게 해줍니다.
* - reduce()와 fold()의 차이점은 초깃값 지정여부에 있습니다.
* - fold()는 초깃값을 지정할 수 있지만, reduce()는 불가능합니다.*/

var result = listOf(1,2,7).fold(10, {total, next ->
//    println("$total... $next")
    total + next
})

/* fold()는 위의 예처럼 값을 더하는데도 사용할 수 있지만, 전체 데이터 중 max 값을 구하는 등의 알고리즘에도 사용할 수 있습니다.*/

var result2 = listOf(1, 11, 5).fold(10){ max, next ->
    if(next > max){
        next
    } else {
        max
    }
}

/* foldRight() 전달되는 데이터가 마지막부터 거꾸로 전달되며 람다함수의 매개변수도 첫 번째가 전달되는 데이터, 두 번째가 이전 결괏값입니다.*/
var result3 = listOf(1,2,3).foldRight(4){next, total ->
    println("$total... $next")
    total - next
}

fun main() {
//    println("fold test: $result")

//    println("fold test2: $result2")

    println("fold Test3: $result3")
}


