# 1. 플래그 (Flag)
1. 플래그 </br>
</t>: 새로운 액티비티를 띄울 때 startActivity() 또는 startActivityForResult()를 여러 번 사용하는 경우 중복된 액티비티가 뜨기 되는 것을 막기위해 사용하는 방식</br>

    1) 액티비티의 처리방식</br>
</t>: 액티비티는 ActivityManager에 의해 'Activity Stack'이라는 걸로 관리됨</br>
</t>: 즉, 새로운 화면이 보이면 이전의 화면은 뒤에 가려져 있음</br>
   ![activityStack](https://github.com/sgmsgood/android_kotlin/blob/master/img/04_activity/activityStack.png?raw=true)

   2) 문제점</br>
</t>: 같은 액티비티가 여러번 호출되면 동일한 액티비티가 같은 액티비티에 들어가게 되고 동시에 데이터를 여러 번 접근하거나 리소스를 여러 번 사용하게 됨</br>
</t>: flag가 이러한 문제를 해결할 수 있음</br>

* 대표적 프래그</br>
    1. FLAG_ACTIVITY_SINGLE_TOP</br>
    </t>: 액티비티를 생성할 때, 이미 생성된 액티비티가 있으면 그 액티비티를 그대로 사용</br>
    </t>: 기존의 액티비티가 사용되는데도 '인텐트 객체'를 전달받을 수 있는 방법 = onNewIntent()</br>
        * 새로운 액티비티를 호출하는 액티비티 = 부모 액티비티</br>
          -> 부모 액티비티로부터 하는 인텐트는 새로 만들어진 인텐트의 onCreate() 메서드 안에서 getIntent()로 참조 가능</br>
          -> but, 액티비티 재사용 시 액티비티의 onCreate() 호출 불가능</br>
          -> 그러므로 **onNewIntent(Intent intent)** 메서드를 재정의하여 객체만 전달</br>
          -> 브로드 캐스트에서 자세히 설명

            ![FLAG_ACTIVITY_SINGLE_TOP](https://github.com/sgmsgood/android_kotlin/blob/master/img/04_activity/FLAG_ACTIVITY_SINGLE_TOP.png?raw=true)</br> 
    

    2. FLAG_ACTIVITY_HISTORY</br>
    </t>: 알람 이벤트가 발생하여 한 번만 알림 화면을 보여주고 싶을 때 사용</br>
    </t>: 처음 이후에 발생한 액티비티가 스택에 추가되지 않음</br>
        -> [back]키를 누르면 언제나 맨 처음의 액티비티가 바로 보임 </br>

         ![FLAG_ACTIVITY_NO_HISTORY](https://github.com/sgmsgood/android_kotlin/blob/master/img/04_activity/FLAG_ACTIVITY_NO_HISTORY.png?raw=true)</br>
         
    3. FLAG_ACTIVITY_CLEAR_TOP</br>
    </t>: 알람 이벤트가 발생하여 한 번만 알림 화면을 보여주고 싶을 때 사용</br>
    </t>: 처음 이후에 발생한 액티비티가 스택에 추가되지 않음</br>
        -> [back]키를 누르면 언제나 맨 처음의 액티비티가 바로 보임 </br>

         ![FLAG_ACTIVITY_NO_HISTORY](https://github.com/sgmsgood/android_kotlin/blob/master/img/04_activity/FLAG_ACTIVITY_NO_HISTORY.png?raw=true)</br>
         
    3. FLAG_ACTIVITY_CLEAR_TOP</br>
    </t>: 이 액티비티 위에 있는 모든 액티비티를 모두 종료함 </br>
    </t>: 홈 화면과 같이 무엇보다 우선 시 되어야 하는 액티비티의 경우 사용</br>
         ![FLAG_ACTIVITY_SINGLE_TOP](https://github.com/sgmsgood/android_kotlin/blob/master/img/04_activity/FLAG_ACTIVITY_SINGLE_TOP.png?raw=true) </br>

--- 
</br>

# 2. 부가데이터 







