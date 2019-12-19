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
        EasyLog.logV("MainActivity","Verbose message")
        EasyLog.logI("MainActivity","Info message")
        EasyLog.logD("MainActivity","Debug message")
        EasyLog.logW("MainActivity","Debug message")
        EasyLog.logE("MainActivity","Error message")
        EasyToast.showToast(this,"Hello Toast!")
    }
}
