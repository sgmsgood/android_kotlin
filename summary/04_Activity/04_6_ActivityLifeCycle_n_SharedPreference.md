# 1. 액티비티 생명주기
* onCreate -> onStart -> **onResume** -> **onPause** -> onStop -> onDestroy

# 2. SharedPreference
* SharedPreference </br>
</t>: 앱 안에서 간단한 데이터를 저장하거나 복원할 때 사용하는 메서드
</t>: 앱 내부에 파일을 하나 만들어서 이 파일 안에서 데이터를 저장 or 복원함

1) SharedPreference 저장하기</br>
</t>: SharedPreference.Edit 객체는 데이터를 저장할 수 있도록 edit() 메서드 제공</br>
</t>: edit() 메서드 호출 후 **put데이터형()** 메서드로 저장하려는 데이터 설정 가능 
```kotlin
    protected fun saveState() {
        //첫 번째 파라미터: "pref"는 저장소의 이름
        val pref: SharedPreferences = getSharedPreferences("pref", Activity.MODE_PRIVATE)
        val editor = pref.edit()

        editor.putString("name", editText.text.toString())
        editor.commit()
    }
```

2) SharedPreference 복원하기</br>
</t>: **get데이터형()**으로 데이터 복원

```kotlin
    protected fun restoreState() {
        val pref: SharedPreferences = getSharedPreferences("pref", Activity.MODE_PRIVATE)

        if ((pref != null) && (pref.contains("name"))) {
            var name = pref.getString("name", "")
            editText.setText(name)
        }
    }
```