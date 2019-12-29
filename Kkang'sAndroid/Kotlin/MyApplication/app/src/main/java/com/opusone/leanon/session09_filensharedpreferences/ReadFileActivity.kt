package com.opusone.leanon.session09_filensharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import kotlinx.android.synthetic.main.activity_read_file.*
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.lang.Exception

class ReadFileActivity : AppCompatActivity() {

    private val TAG = "ReadFileActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_file)

        val file = getAppDataFileFormEX("/myApp/myfile.txt")

        try {
            val reader = BufferedReader(FileReader(file))
            val buffer = StringBuffer()
            val line: String = reader.readLine()

            while (line != null) {
                buffer.append(line)
            }
            fileResult.text = buffer.toString()

            reader.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun getAppDataFileFormEX(saveFile: String): File {
        val dir = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)

        dir?.mkdirs()

        return File("${File.separator}${saveFile}")
    }

    private fun print(contents: String) {
        Log.d(TAG, "##$contents")
    }
}
