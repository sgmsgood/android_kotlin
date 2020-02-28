package com.opusone.leanon.testtts

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.text.Editable
import android.util.Log
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import java.lang.Exception
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    private val TAG = "MainActivity"

    lateinit var textToSpeech: TextToSpeech
    var speed: Float = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "##onCreate")

        textToSpeech = TextToSpeech(applicationContext, this)

        initButton()
    }

    private fun initButton(){
        Log.d(TAG, "##initButton")

        playStopBtn.setOnClickListener{
            if(playStopBtn.text.toString() == "▶︎"){
                Speech()
                playStopBtn.text = "◼︎"
            } else {
                //재생이 멈췄을 때, "◼︎"로 바뀔 수 있게 구현 필요
                textToSpeech.stop()
                playStopBtn.text = "▶︎"
            }
        }
    }

    override fun onInit(status: Int) {

        if (status == TextToSpeech.SUCCESS) {
            Log.d(TAG, "##onInit")
            val result = textToSpeech.setLanguage(Locale.KOREAN)

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "Language is not supported")

            } else {

                playStopBtn.isEnabled = true

                seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
                    override fun onProgressChanged(
                        seekBar: SeekBar?,
                        progress: Int,
                        fromUser: Boolean
                    ) {
                        speed = ((seekBar?.progress)?.toFloat()?.div(10.toFloat())) ?: 1.0f
                        Toast.makeText(applicationContext, "${speed}", Toast.LENGTH_SHORT).show()

                        setSpeechForm(speed)
                    }

                    override fun onStartTrackingTouch(seekBar: SeekBar?) {

                    }

                    override fun onStopTrackingTouch(seekBar: SeekBar?) {

                    }

                })
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()

        textToSpeech.stop()
        textToSpeech.shutdown()
    }

    override fun onStop() {
        super.onStop()

        textToSpeech.stop()
        textToSpeech.shutdown()
    }

    private fun Speech() {
        val text = editTextView.text.toString()
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
        Waiter().execute()
    }

    private fun setSpeechForm(speed:Float){
        textToSpeech.setPitch(5.0f)
        textToSpeech.setSpeechRate(1.0f)
    }

    inner class Waiter: AsyncTask<Any, Any, Any>() {
        override fun doInBackground(vararg params: Any?) {
            while(textToSpeech.isSpeaking){
                try{
                    Thread.sleep(1000)
                } catch (e: Exception) {

                }
            }

            return
        }

        override fun onPostExecute(result: Any?) {
            playStopBtn.text = "▶︎"
        }
    }
}
