package com.jakir.cse24.easyalert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        EasyLog.logD("MainActivity","message")
        EasyToast.showErrorToast(this,"Hello Toast!")
    }
}
