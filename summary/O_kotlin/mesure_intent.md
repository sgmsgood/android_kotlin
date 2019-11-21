# 비만도 계산기 만들기
출처: 오준석의 안드로이드 생존코딩 (5장)
### 1. 어플 설명
</t>: 키와 몸무게를 입력받아 BMI를 계산하고, 비만의 정도를 출력해주는 어플

### 2. 구현 기능
* 업 내비게이션 구현
* 인텐트</br>
</t>: 액티비티 간 전환 및 데이터 교류
* SharedReference</br>
</t>: 데이터 저장기능으로 onDestroy() 후에도 데이터 복구가능
* Anko Library</br>
</t>: 코틀린 개발한 젯브레인에서 개발
    * Anko Commons: 인텐트, 다이얼로그, 로그 등을 편리하게 사용하는 라이브러리
    * Anko Layouts: 안드로이드 레이아웃을 코드로 쉽게 작성하는 라이브러리
    * Anko SQLite: SQLite를 쉽게 사용하는 라이브러리
    * Anko Coroutines: 코루틴을 쉽게 사용하는 라이브러리

### 3. 주요 코드
1) Intent
* [버튼] 클릭 -> EditText에서 받은 데이터 전달하기
    * intent.putExtra("key", "value")

<코틀린 기본 Intent 코드_MainActivity.kt>
```kotlin
override fun onCreate(savedInstanceState: Bundle?){
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    resultButton.setOnClickListener{
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("weight", weightEditText.text.toString())
        intent.putExtra("hetight", heightEditText.text.toString())

        startActivity(intent)
    }
}
```
<Anko 라이브러리를 적용한 코틀린의 액티비티 전환 코드_MainActivity.kt>
```kotlin
override fun onCreate(savedInstanceState: Bundle?){
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

        startActivity<ResultActivity>(
            "weight" to weightEditText.text.toString(),
            "height" to heightEditText.text.toString()
        )

}
```

* 인텐트로 받은 데이터 꺼내기_ResultActivity.kt
    * MainActivity에서 전달할 때 설정했던 "key"로 꺼냄.
    * intent.getStringExtra("key")
```kotlin
    val height = intent.getStringExtra("height").toString()
    val weight = intent.getStringExtra("weight").toString()
```
---
2. sharedPreference
* 데이터 저장하기_MainActivity.kt
```kotlin
private fun saveData(height: Int, weight:Int){
        val pref = getSharedPreferences("pref", 0)
        val editor = pref.edit()

        editor.putInt("KEY_HEIGHT", height)
            .putInt("KEY_WEIGHT", weight)
            .apply()
}
```

* 데이터 출력하기_MainActivity.kt
```kotlin
private fun loadData(){
        val pref = getSharedPreferences("pref", 0)
        val height = pref.getInt("KEY_HEIGHT",0)
        val weight = pref.getInt("KEY_WEIGHT", 0)

        if(height != 0 && weight != 0){

            heightEditText.setText(height.toString())
            weightEditText.setText(weight.toString())
        }
    }
```




