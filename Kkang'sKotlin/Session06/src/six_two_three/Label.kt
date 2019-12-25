package six_two_three

fun main() {
    aaa@ for (i in 1..3) {
        for(j in 1..3){
            if(j > 1) {
                break@aaa
            }
            println("i: $i, j: $j")
        }
    }
}
