package com.opusone.leanon.testpedrolib

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.pedro.library.AutoPermissions
import com.pedro.library.AutoPermissionsListener
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(), AutoPermissionsListener {

    var manager: LocationManager? = null

    var enabledProviders: MutableList<String>? = null
    var bestAccuracy: Float = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AutoPermissions.loadAllPermissions(this, 1)

        cameraBtn.setOnClickListener {

            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CAMERA
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                AutoPermissions.loadAllPermissions(this, 1)
            } else {
                val intent = Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA)
                if (intent.resolveActivity(packageManager) != null) {
                    startActivityForResult(intent, 1)
                }
            }
        }
    }

    override fun onGranted(requestCode: Int, permissions: Array<String>) {
        Toast.makeText(
            this,
            "0: ${permissions.get(0)}, 1:${permissions.get(1)}\\n  ${permissions.size} permissions granted",
            Toast.LENGTH_SHORT
        ).show()

        var grantedPermission = ""

        permissions.forEach {
            grantedPermission += "\n" + it
        }

        resultView.text = grantedPermission

        alert(grantedPermission, "Granted Permission") {
            negativeButton("확인") {

            }
        }
    }

    override fun onDenied(requestCode: Int, permissions: Array<String>) {
        Toast.makeText(this, "${permissions.size} permissions no granted", Toast.LENGTH_SHORT)
            .show()

        var notGrantedPermission = ""

        permissions.forEach {
            notGrantedPermission += "\n" + it
        }

        noResultView.text = notGrantedPermission
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        AutoPermissions.parsePermissions(this, requestCode, permissions, this)
    }
}