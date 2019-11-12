# 액티비티 (화면 전환)
### 1. 앱의 4가지 요소
1) **액티비티**
2) 서비스
3) 브로드캐스트 수신자
4) 내용 제공자 </br>
</t> * 위의 정보들은 'Android-Menifest.xml'에 정보들을 담고 있음. </br>
</t> * 새로 생성되면, 'Android-Menifest.xml'에 추가해야 시스템이 인지함

### 2. startActivity()와 startActivityForResult()
* startActivity() </br> 
: 단순히 'A 액티비티'에서 'B 액티비티'를 띄워줌 </br>

* startActivityForResult() </br>
: 'A 액티비티'에서 띄운 'B 액티비티'에서 처리할 데이터를 가지고 돌아옴 </br>
: 인자값 (intent, requestCode) </br>
</t> * requestCode = 정수로 된 코드값
---



### 정리) 
* 액티비티 띄우기
1. 새로운 액티비티 만들기</br>
</t>: 새로운 액티비티를 추가하면 XML 레이아웃 파일 하나와 자바 소스 파일 하나가 만들어지고 매니페스트 파일에 액티비티 태그 추가.  
```kotlin
// 액티비티를 Dialog 형태로 변경하는 코드
<activity android:name=".MenuActivity"
            android:label="메뉴 액티비티"
            android:theme="@style/Theme.AppCompat.Dialog">
```
    

2. 새로운 액티비티의 xml 레이아웃 정의하기</br>
    : 새로 만들어진 XML 레이아웃을 수정하여 새로운 액티비의 화면이 어떻게 배치될 지 작성</br>

3. MainActivity에서 새로운 액티비티 띄우기</br>
</t>: 메인 액티비티의 버튼을 클릭하면 startActivityForResult() 메서드로 새로운 액티비티 띄우기</br>
    * // 1. REQUEST_CODE_MENU </br> 
        : 새 액티비티로부터 응답받을 때 다시 전달받을 값 </br>
        </t>(= 어디로부터 온 값인지 구분할 수 있음) </br>
        : 값은 마음대로 지정 가능 (but, 액티비가 여러개일 경우 중복되지 않는 값으로) </br>

  
    ```kotlin
    class MainActivity : AppCompatActivity() {

        //1. 새 액티비를 띄울 때 보낼 요청코드
        val REQUEST_CODE_MENU = 101

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            button.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_MENU) 
            }
        }    
    }
    ```
    4. 새로운 액티비티에서 응답보내기</br>
    </t>: 새로운 액티비티가 보이고 그 안에 들어있는 버튼을 누르면 setResult() 메서드로 응답을 보냄
    ```kotlin
     class MenuActivity : AppCompatActivity() {

         override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_menu)

            button.setOnClickListener {
                val intent = Intent()
            
                intent.putExtra("name", "Elena")
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }
    ```
    5. 응답처리하기</br>
    </t>: 메인 액티비티에서 onActivityResult() 메서드를 재정의하여 새로 띄웠던 액티비티에서 보내오는 응답을 처리합니다.
        * onActivityResult (requestCode: Int, resultCode: Int, data: Intent?) </br>
        </t> : MenuActivity로부터 받은 응답을 처리하는 메서드</br>
        </t> (새로 띄웠던 MenuActivity가 응답을 보내오면 그 응답을 처리하는 역할)</br>
        </t> - 첫 번째 인자값: 액티비티를 처음 띄울 때 전달했던 요청 코드 (101) </br> </t> - 두 번째 인자값: 새 액티비티로부터 전달된 코드 </br>
        </t> (새 액티비티에서 처리한 결과가 정상인지 아닌지 구분하는데 사용 </br>
        </t>  Ex) Activity.RESULT_OK)</br>
        </t> - 세 번째 인자값: 새 액티티로부터 전달받은 인텐트 값 </br>
    ```kotlin
        // MenuActivity로부터 받은 응답을 처리하는 메서드
        override fun onActivityResult(
            requestCode: Int, 
            resultCode: Int, 
            data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)

            if(requestCode == REQUEST_CODE_MENU){
               Toast.makeText(this, 
               "onActivityResult 메소드 호출 됨. 요청코드: " + requestCode + 
               ", 결과코드: " + resultCode, Toast.LENGTH_SHORT).show()

                if(resultCode == Activity.RESULT_OK){
                    var name = data?.getStringExtra("name")
                    Toast.makeText(this, "응답으로 전달된 name: " + name,
                    Toast.LENGTH_SHORT).show()
                }
            }
    ```   


