package com.opusone.leanon.bloodpressure

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : AppCompatActivity() {

    val fragmentManager: FragmentManager = supportFragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)


        cancelButton.setOnClickListener {
            val intent = Intent()
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        changeFragment(FirstStepFragment())

        preparingProductBtn.setOnClickListener {
            changeFragment(FirstStepFragment())
        }

        paringModeBtn.setOnClickListener {
            changeFragment(SecondStepFragment())
        }

        searchingProductBtn.setOnClickListener {
            changeFragment(ThirdStepFragment())
        }

        confirmConnectionBtn.setOnClickListener {
            changeFragment(FourthStepFragment())
        }
    }

    private fun changeFragment(fragment: Fragment) {
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment, fragment).commit();
    }
}
