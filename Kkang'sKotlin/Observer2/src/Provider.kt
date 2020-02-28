class Provider {
    val observerList = arrayListOf<(Int) -> Unit>()
    private var count = 0

    fun generate(): Int {
        observerList.forEach {
            it(count)
        }
        return ++count
    }
}