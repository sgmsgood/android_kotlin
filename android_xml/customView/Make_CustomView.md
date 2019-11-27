# CustomView 만들기
1. 구현동기</br>
</t>- 동일한 형태에 크기만 다른 버튼의 반복 생성의 불편함</br>
</t>- 기본 형태는 유지되면서 쉽게 유지보수 가능한 버튼의 필요성</br>

2. customView란?</br>
</t>- 필요에 따라 독자적인 레이아웃을 적용하여 view 구현 가능 </br>
</t>- 유사한 view를 재활용 함으로써 레이아웃을 구현하는데 효율성 향상 </br>

3. customView 만드는 법</br>
</t>1) View 클래스를 상속받는 새로운 클래스 생성하기</br>
</t>2) res 폴더에 attr (attribute) 파일 생성</br>
</t>3) 이곳에서 생성한 name 값으로 view의 요소를 custom하게 설정할 수 있음</br>
</t>4) mainActivity에 구현</br>

4. 문제가 되었던 부분</br>
</t> 1) setMargin() 메소드를 생성하면서 OoButtonView의 LayoutParam 객체 생성</br>
</t>-> 문제점</br>
</t>: margin을 적용하기 위한 OoButtonView의 LayoutParam을 만들기 위해 레이아웃을 동적으로 생성할 때 사용하는 아래의 코드를 init에 적용했음.
</t>layoutParam은 margin을 적용하기 위해서 불러오는 값이기 때문에, setMargin() 메소드와 함께 적용되어야 한다고 생각했으나, 
init 위치를 벗어나 해당 위치인 setMargin에 코딩하면 작동하지 않는 문제가 발생함.</br>
</t>-> 이유</br>
</t>: 기본 layout틀이 만들어지는 코드가 생성하는 순간에 만들지 않고, 다 만들어진 코드 안에서 다시 layout을 새로 만들어서 적용하려고 하니까 생기는 문제</br>
</t>-> 해결방법</br>
</t>: 새롭게 layout을 만드는 코드가 아니라, 있는 OoButtonView의 layoutParam을 불러와서 setMargin을 해주는 방법으로 해결.

<문제가 되었던 코드>
```kotlin
var layoutParam = null
init{
    layoutParam = LayoutParams(
        LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
}
...생략...
private fun setMargin(pixelWidth: Int, pixelHeight: Int) {
    layoutParam.setMargins(marginPxLeft, marginPxTop, marginPxRight, marginPxBottom)
    OoButtonView.layoutParams = layoutParam
}
```
<해결 코드>
```kotlin
private fun setMargin(pixelWidth: Int, pixelHeight: Int) {
    val layoutParameter = OoButtonView.layoutParams as LayoutParams
    layoutParameter.setMargins(marginPxLeft, marginPxTop, marginPxRight, marginPxBottom)
    OoButtonView.layoutParams = layoutParameter
}
```
</t> 2) ViewGroup의 생명주기와 관련된 view를 그려주는 타이밍에 관한 문제 </br>
</t>-> 문제점</br>
</t>: acitivity_main.xml에서 설정한 attr 값을 불러오는 시점(init)과 view의 width, height를 구하는 시점(onMeasure)의 차이로 isKeepShadowMargin을 적용하지 못함. 즉, viewGroup의 생명주기 흐름 상, onMeasure에서 view의 크기를 측정하기 전에 init에서 view의 margin을 설정하려고 하면서 발생한 문제</br>
</t>-> 해결방법</br>
</t>: viewGroup의 생명주기를 파악하고, view가 그려지는 onLayout()에서 view가 그려지게 함. </br>
</t>: init에서는 attr값을 parsing</br>
</t>: onMeasure()에서는 width, height 사이즈를 측정</br>
</t>: onLayout()을 override하여 init에서 parsing한 attr값을 적용</br>

```kotlin
    init {
        layoutView = LayoutInflater.from(context).inflate(R.layout.my_custom_view, this, true)

        attrs?.let {
            val attrsArray = context.obtainStyledAttributes(attrs, R.styleable.OoFlatButton, 0, 0)

            parseAttrs(attrsArray)
        }
    }

    private fun parseAttrs(attrsArray: TypedArray) {
        textString = attrsArray.getString(R.styleable.OoFlatButton_Text) ?: ""

        floatFontSize =
            attrsArray.getDimensionPixelSize(R.styleable.OoFlatButton_FontSize, 0).toFloat()

        bgButton =
            attrsArray.getResourceId(R.styleable.OoFlatButton_BackGround, R.drawable.basic_button)

        isShadow = attrsArray.getBoolean(R.styleable.OoFlatButton_isShadow, true)

        isKeepShadowMargin =
            attrsArray.getBoolean(R.styleable.OoFlatButton_isKeepshadowMargin, true)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        pixelWidth = MeasureSpec.getSize(widthMeasureSpec)
        pixelHeight = MeasureSpec.getSize(heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        Log.d(TAG, "##changed: $changed")

        renderShadow()
        renderShadowMargin()
        setButtonAttr()
    }

...생략...
```
