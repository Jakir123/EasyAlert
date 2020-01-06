package com.jakir.cse24.easyalert

import android.graphics.Color
import android.graphics.Typeface
import android.icu.lang.UCharacter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        EasyToast.Customization.instance
            .hasIcon(true)
            .setIcon(R.drawable.ic_menu_arrow_up_black_24dp)
            .setBacgroudColor(R.color.color_black)
            .setTextColor(R.color.color_white)
            .setTextSize(18)

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
