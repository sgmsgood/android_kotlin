fun main() {
    val provider = Provider()

    provider.observerList.add{
        println("frg1: $it")
    }

    provider.observerList.add{
        println("frg2: $it")
    }

    provider.generate()
    provider.generate()
}

fun println1(x: Int){
    println("fragment: x")
}