package com.elen.part14_implicitintent

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.os.Environment.getExternalStorageState
import android.provider.ContactsContract
import android.provider.MediaStore
import android.speech.RecognizerIntent
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.FileInputStream
import java.lang.Exception
import java.util.jar.Manifest

class MainActivity : AppCompatActivity(){

    lateinit var filePath: File

    var reqHeight = 0
    var reqWidth = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnContacts.setOnClickListener {
            Toast.makeText(this, "주소록 앱 연동", Toast.LENGTH_SHORT).show()
            val intent = Intent(Intent.ACTION_PICK)
            intent.setData(ContactsContract.CommonDataKinds.Phone.CONTENT_URI)
            startActivityForResult(intent, 10)
        }

        btnCameraData.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, 30)
        }

        btnCameraFile.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                try {
                    val dirPath: String =
                        getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS).toString() + "/myApp"
                    val dir = File(dirPath)
                    if (!dir.exists()) {
                        dir.mkdir()
                    }

                    filePath = File.createTempFile("IMG", ".jpg", dir)
                    if (!filePath.exists()) {
                        filePath.createNewFile()
                    }

                    val photoURI: Uri = FileProvider.getUriForFile(
                        this,
                        "${BuildConfig.APPLICATION_ID}.provider",
                        filePath
                    )
                    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

                    intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    startActivityForResult(intent, 40)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            } else {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    100
                )
            }
        }

        btnSpeech.setOnClickListener {
            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            intent.putExtra(
                RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
            )
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "음성인식 테스트")
            startActivityForResult(intent, 50)
        }

        btnMap.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.5662957, 126.9779451"))
            startActivity(intent)
        }

        btnBrowser.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.seoul.go.kr"))
            startActivity(intent)
        }

        btnCall.setOnClickListener {
            if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) ==
                PackageManager.PERMISSION_GRANTED) {
                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:02-120"))
                startActivity(intent)
            } else {
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), 100)
            }
        }

        resultImageView.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW

            val photoURI = FileProvider.getUriForFile(this, "${BuildConfig.APPLICATION_ID}.provider", filePath)
            intent.setDataAndType(photoURI, "image/*")
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == 10 && resultCode == Activity.RESULT_OK){
            val result = data?.dataString
            resultView.text = result
        } else if(requestCode == 30 && resultCode == Activity.RESULT_OK){
            val bitmap = data?.extras?.get("data") as Bitmap
            resultImageView.setImageBitmap(bitmap)
        } else if(requestCode == 40 && resultCode == Activity.RESULT_OK) {
            if(filePath != null) {
                val options: BitmapFactory.Options = BitmapFactory.Options()
                options.inJustDecodeBounds = true
                try{
                    var fileIn: FileInputStream? = FileInputStream(filePath)
                    BitmapFactory.decodeStream(fileIn, null, options)
                    fileIn?.close()
                    fileIn = null
                } catch (e: Exception) {
                    e.printStackTrace()
                }

                val height = options.outHeight
                val width = options.outWidth
                var inSampleSize = 1

                if(height > reqHeight || width > reqWidth) {
                    val heightRatio = Math.round(height.toFloat() / reqHeight.toFloat())
                    val widthRatio = Math.round(width.toFloat() / reqWidth.toFloat())

                    inSampleSize = if(heightRatio < widthRatio) heightRatio else widthRatio
                }

                val imgOptions = BitmapFactory.Options()
                imgOptions.inSampleSize = inSampleSize

                val bitmap = BitmapFactory.decodeFile(filePath.absolutePath, imgOptions)
                resultImageView.setImageBitmap(bitmap)
            }
        } else if (requestCode == 50 && resultCode == Activity.RESULT_OK) {
            val results = data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            val result = results?.get(0)
            resultView.text = result
        }
    }
}
