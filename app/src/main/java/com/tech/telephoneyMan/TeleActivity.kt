package com.tech.telephoneyMan

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.telephony.TelephonyManager
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.fragment.R
import kotlinx.android.synthetic.main.activity_home.*


class TeleActivity : AppCompatActivity() {
    val permission = 101

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContentView(R.layout.activity_tele)
        //Get the instance of TelephonyManager
        //Get the instance of TelephonyManager
        val tm = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        //Calling the methods of TelephonyManager the returns the information
        //Calling the methods of TelephonyManager the returns the information
     //   val IMEINumber = tm.deviceId
     //   val subscriberID = tm.deviceId
     //   val SIMSerialNumber = tm.simSerialNumber
        val networkCountryISO = tm.networkCountryIso
        val SIMCountryISO = tm.simCountryIso
    //    val softwareVersion = tm.deviceSoftwareVersion
    //    val voiceMailNumber = tm.voiceMailNumber

        //Get the phone type
        //Get the phone type
        var strphoneType = ""

        val phoneType = tm.phoneType

        when (phoneType) {
            TelephonyManager.PHONE_TYPE_CDMA -> strphoneType = "CDMA"
            TelephonyManager.PHONE_TYPE_GSM -> strphoneType = "GSM"
            TelephonyManager.PHONE_TYPE_NONE -> strphoneType = "NONE"
        }

        //getting information if phone is in roaming

        //getting information if phone is in roaming
        val isRoaming = tm.isNetworkRoaming

        var info = "Phone Details:\n"
      //  info += "\n IMEI Number:$IMEINumber"
      //  info += "\n SubscriberID:$subscriberID"
      //  info += "\n Sim Serial Number:$SIMSerialNumber"
        info += "\n Network Country ISO:$networkCountryISO"
        info += "\n SIM Country ISO:$SIMCountryISO"
       // info += "\n Software Version:$softwareVersion"
      //  info += "\n Voice Mail Number:$voiceMailNumber"
        info += "\n Phone Network Type:$strphoneType"
        info += "\n In Roaming? :$isRoaming"


        Log.e("TAG", "onCreate: " + info)

        //call()

        Log.e("TAG", "onCreate: " + getPhoneModel())

        val telephonyManager = getSystemService(Context.TELEPHONY_SERVICE) as
                TelephonyManager
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) !=
            PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_PHONE_NUMBERS
            ) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) !=
            PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_PHONE_STATE),
                permission
            )
        }



        // Missing here
        Log.e("TAG", "TelePhone: " + telephonyManager.line1Number)

//        Log.e("TAG", "SubscriberId: " + telephonyManager.subscriberId)


        Log.e("TAG", "CelInfo: " + telephonyManager.allCellInfo)

        Log.e("TAG", "DeviceId: " + getDeviceId(activity.context))


    }
    fun call() {
        val dialIntent = Intent(Intent.ACTION_DIAL)
        dialIntent.data = Uri.parse("tel:" + "9988200178")
        startActivity(dialIntent)
    }
    private fun getPhoneModel(): String? {
        return Build.MODEL
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            permission -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    fun getDeviceId(context: Context): String? {
        val deviceId: String
        deviceId = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            Settings.Secure.getString(
                context.contentResolver,
                Settings.Secure.ANDROID_ID
            )
        } else {
            val mTelephony = context.getSystemService(TELEPHONY_SERVICE) as TelephonyManager
            if (mTelephony.deviceId != null) {
                mTelephony.deviceId
            } else {
                Settings.Secure.getString(
                    context.contentResolver,
                    Settings.Secure.ANDROID_ID
                )
            }
        }
        return deviceId
    }
}