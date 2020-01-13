package com.opusone.leanon.testpermission

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    var manager: LocationManager? = null

    var enabledProviders: MutableList<String>? = null
    var bestAccuracy: Float = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        manager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                100
            )

        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO),
                100
            )

        }


//        else {
//            getLocation()
//            getProviders()
//        }




    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun getProviders() {
        var result = "All Providers: "

        val providers: List<String> = manager!!.allProviders

        providers.forEach {
            result += it + ","
        }

        allProvidersView.text = result

        result = "Enabled Providers: "
        enabledProviders = manager!!.getProviders(true)
        enabledProviders?.forEach {
            result += it + ","
        }

        enableProvidersView.text = result
    }

    private fun getLocation() {

        enabledProviders?.forEach {
            var location: Location? = null

            if ((ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION))
                == PackageManager.PERMISSION_GRANTED
            ) {
                location = manager!!.getLastKnownLocation(it)
            } else {
                showToast("no Permission..")
            }

            if (location != null) {
                val accuracy: Float = location.accuracy

                if (bestAccuracy == 0f) {
                    bestAccuracy = accuracy
                    setLocationInfo(it, location)
                } else {
                    if (accuracy < bestAccuracy) {
                        bestAccuracy = accuracy
                        setLocationInfo(it, location)
                    }
                }
            }
        }
    }

    private fun setLocationInfo(provider: String, location: Location) {
        if (location != null) {
            providerView.text = provider
            latitudeView.text = location.latitude.toString()
            longitudeView.text = location.longitude.toString()
            accuracyView.text = location.accuracy.toString()

            val date = Date(location.time)
            val sd = SimpleDateFormat("yyyy-MM-dd HH:mm")
            timeView.text = sd.format(date)
            onOffView.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    R.drawable.ic_on,
                    null
                )
            )

        } else {
            showToast("loaction null....")
        }
    }
}
