package com.jakir.cse24.easyalert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun show(view: View) {
        EasyLog.logV("Verbose message","MainActivity")
        EasyLog.logI("Info message")
        EasyLog.logD("Debug message","MainActivity")
        EasyLog.logW("Debug message","MainActivity")
        EasyLog.logE("Error message","MainActivity")
        EasyToast.showToast(this,"Hello Toast!")
    }
}
