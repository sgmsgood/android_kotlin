package nine_two_one

import nine_one_two.Shape

open class Shape{
    var x: Int = 0
        set(value){
            if(value < 0) {
                field = 0
            } else {
                field = value
            }
        }

    var y: Int = 0
        set(value){
            if(value < 0){
                field = 0
            } else {
                field = value
            }
        }

    lateinit var name: String

    open fun print() {
        println("$name: location: $x, $y")
    }
}

class Rect: Shape(){
    var width: Int = 0
        set(value){
            if(value < 0) {
                field = 0
            } else {
                field = value
            }
        }

    var height: Int = 0
        set(value){
            if(value < 0) {
                field = 0

            } else{
                field = value
            }
        }

//    override fun print(){
//        println("$name: location: $x, $y...width: $width .... height: $height")
//    }
}

class Circle: Shape(){
    var r: Int = 0
        set(value){
            if(value < 0){
                field = 0
            } else {
                field = value
            }
        }

//    override fun print(){
//        println("$name: location: $x, $y...radius: $r")
//    }
}

