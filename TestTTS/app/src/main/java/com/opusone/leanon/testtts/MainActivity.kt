package com.opusone.leanon.testtts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener, SeekBar.OnSeekBarChangeListener {

    private val TAG = "MainActivity"

    lateinit var textToSpeech: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "##onCreate")

        textToSpeech = TextToSpeech(applicationContext, this)

        seekBar.progress = 0.5.toInt()
        initButton()
    }

    private fun initButton(){
        Log.d(TAG, "##initButton")

        playStopBtn.setOnClickListener{
            if(playStopBtn.text.toString() == "▶︎"){
                Speech()
                playStopBtn.text = "◼︎"
            } else {
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


                var speed =  seekBar.progress.toFloat()

                playStopBtn.isEnabled = true
                textToSpeech.setPitch(1.0f)
                textToSpeech.setSpeechRate(speed)

                /*normalSpeakBtn.setOnClickListener {
                    textToSpeech.setSpeechRate(1.0f)
                }

                slowSpeakBtn.setOnClickListener {
                    textToSpeech.setSpeechRate(0.5f)
                }

                fastSpeakBtn.setOnClickListener {
                    textToSpeech.setSpeechRate(2.0f)
                }*/
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
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
     
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
