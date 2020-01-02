package com.elen.part16_threadnhandler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    var loopFlag = true
    var isFirst = true
    var isRun = false

    var thread: MyThread? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        thread = MyThread()

        main_startBtn.setOnClickListener {
            Toast.makeText(this, "??", Toast.LENGTH_SHORT).show()
            if(isFirst){
                isFirst = false
                isRun = true
                thread?.start()
            } else {
                isRun = true
            }
        }

        main_pauseBtn.setOnClickListener {
            isRun = false
        }
    }

    val handler = object: Handler(){
        override fun handleMessage(msg: Message) {
            if(msg.what == 1){
                main_textView.text = msg.arg1.toString()
            } else if (msg.what == 2){
                main_textView.text = msg.obj.toString()
            }
        }
    }

   inner class MyThread: Thread() {
        override fun run() {
            try{
                var count = 10
                while(loopFlag){
                    sleep(1000)
                    if(isRun){
                        count--
                        var message = Message()
                        message.what = 1
                        message.arg1 = count
                        handler.sendMessage(message)

                        if(count == 0){
                            message = Message()
                            message.what = 2
                            message.obj = "Finish!!"
                            handler.sendMessage(message)

                            loopFlag = false
                        }
                    }
                }
            } catch (e: Exception){

            }
        }
    }
}



