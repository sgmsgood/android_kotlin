package com.opusone.leanon.session09_filensharedpreferences

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.FileWriter

class MainActivity : AppCompatActivity() {

    var fileReadPermission: Boolean = false
    var fileWritePermission: Boolean = false

    private val REQUEST_CODE = 200


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            onClick(it)
        }

        checkPermissionState()
    }

    private fun checkPermissionState() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            fileReadPermission = true
        }

        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            fileWritePermission = true
        }

        if (!fileReadPermission || !fileWritePermission) {
            ActivityCompat.requestPermissions(
                this, arrayOf(
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ), REQUEST_CODE
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (REQUEST_CODE == 200 && grantResults.size > 0) {
//            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
//                fileReadPermission ===  true
//            }
//
//            if(grantResults[1] == PackageManager.PERMISSION_GRANTED){
//                fileWritePermission === true
//            }

            when (requestCode) {
                REQUEST_CODE -> {

                    if (grantResults.isEmpty()) {
                        return
                    }

                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                        fileReadPermission = true
                    }
                    if (grantResults[1] == PackageManager.PERMISSION_GRANTED) {

                        fileWritePermission = true
                    }
                }

            }
        }
    }

    private fun onClick(v: View) {
        val content = contents.text.toString()

        if (fileReadPermission && fileWritePermission) {
            val writer: FileWriter

            try {
                val dirPath: String =
                    getExternalFilesDir("${Environment.DIRECTORY_DOCUMENTS}").toString() + "/myApp"

                val dir = File(dirPath)

                if(!dir.exists()){
                    dir.mkdir()
                }

                val file = File("$dir/myfile.txt")

                if(!file.exists()){
                    file.createNewFile()
                }

                writer = FileWriter(file, true)
                writer.write(content)
                writer.flush()
                writer.close()

                val intent = Intent(this, ReadFileActivity::class.java)
                startActivity(intent)

            }catch (e: Exception){
                e.printStackTrace()

            }
        } else {
            showToast("permission이 부여 안 되어 기능을 실행할 수 없습니다.")
        }
    }
        private fun showToast(message: String){
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
}
