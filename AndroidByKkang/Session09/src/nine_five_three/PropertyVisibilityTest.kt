package nine_five_three

class PropertyVisibilityTest private constructor(name: String){

    public constructor(name: String, no: Int): this(name){

    }

    private var data: Int = 10

    fun getData(): Int{
        return data
    }
}