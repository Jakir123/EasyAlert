package com.jakir.cse24.easyalert_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.lifecycle.Observer
import com.jakir.cse24.easyalert.EasyAlert
import com.jakir.cse24.easyalert.EasyLog
import com.jakir.cse24.easyalert.EasyToast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // toast customization
        EasyToast.Customization.instance
            .hasIcon(true)
            .setIcon(R.drawable.ic_menu_arrow_up_black_24dp)
            .setBackgroundColor(R.color.color_black)
            .setTextColor(R.color.color_white)
            .setTextSize(14)

    }

    fun showLogs(view: View) {
        EasyLog.logV("Verbose message", "MainActivity")
        EasyLog.logI("Info message")
        EasyLog.logD("Debug message", "MainActivity")
        EasyLog.logW("Debug message", "MainActivity")
        EasyLog.logE("Error message", "MainActivity")
    }

    fun showProgressDialog(view: View) {
        EasyAlert.showProgressDialog(
            this,
            "showing progress dialog"
        )
        // without message pass only activity reference
        // EasyAlert.showProgressDialog(this)
        Handler().postDelayed({
            EasyAlert.hideProgressDialog()
        }, 5000) // 5 sec
    }

    fun showAlert(view: View) {
        // here icon is optional
        EasyAlert.Customization.instance.setTheme(true)
        EasyAlert.showAlertWithChoice(
            this,
            "Alert with Choices",
            "Do you want to see the default alert?"
        ).observe(this,
            Observer {
                if (it) {
                    // handle ok button click
                    EasyAlert.showAlert(
                        this,
                        "Alert without Choices",
                        "The alert message is here...."
                    ) // also can observe this for doing something when user click on ok.
                } else {
                    // handle cancel button click
                    EasyToast.showToast(
                        this,
                        "You clicked on cancel button!"
                    ) // default toast
                }
            })
    }

    fun showToast(view: View) {
        EasyToast.showInfoToast(
            this,
            "Hello info toast...long message testing....... is it okay now ............ long long message"
        )
//            EasyToast.showErrorToast(this,"Hello error toast...")
//            EasyToast.showSuccessToast(this,"Hello success toast...")
//            EasyToast.showWarningToast(this,"Hello warning toast...")
    }
}
