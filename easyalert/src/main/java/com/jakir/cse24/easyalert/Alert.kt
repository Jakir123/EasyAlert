package com.jakir.cse24.easyalert

import android.app.AlertDialog
import android.content.Context
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.custom_toast.view.*


object Alert {
    /**
     * This method is for printing a ERROR log message on the system console
     * Created by Md. Jakir Hossain on 02/05/2019.
     *
     * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    fun logE(tag: String, msg: String) {
        Log.e("Easy Alert $tag", msg)
    }

    /**
     * This method is for printing a DEBUG log message on the system console
     * Created by Md. Jakir Hossain on 02/05/2019.
     *
     * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    fun logD(tag: String, msg: String) {
        Log.d("Easy Alert $tag", msg)
    }

    /**
     * This method is for showing message using android {@link Toast}
     * Created by Md. Jakir Hossain on 29/04/2019.
     *
     * @param msg message which will display on screen
     */
    fun showToast(context: Context, msg: String) {
        val toast: Toast = customToast(context,msg,R.color.white,R.drawable.ic_check_white_24dp,R.color.white,false)
        toast.show()
    }


    private fun customToast(
        context: Context,
        text: CharSequence,
        textColor: Int,
        icon: Int,
        iconColor: Int,
        hasIcon: Boolean
    ): Toast {
        val layoutInflater = LayoutInflater.from(context)
        val layout =
            layoutInflater.inflate(
                R.layout.custom_toast
                , null
            ).findViewById<ConstraintLayout>(R.id.container)

        if (hasIcon) {
            val drawable = ContextCompat.getDrawable(context,R.drawable.toast_round_bg)
            drawable?.colorFilter = PorterDuffColorFilter(ContextCompat.getColor(context,iconColor),PorterDuff.Mode.MULTIPLY)
            layout.background = drawable
            layout.imvIcon.setImageDrawable(ContextCompat.getDrawable(context,icon))
        } else {
            layout.imvIcon.visibility = View.GONE
        }

        layout.tvMessage.setTextColor(ContextCompat.getColor(context,textColor))
        layout.tvMessage.text = text

        val toast = Toast(context)
        toast.duration = Toast.LENGTH_LONG
        toast.setGravity(Gravity.CENTER,0,0)
        toast.view = layout

        return toast
    }

    /**
     * This method is for showing error/warning using alert dialog.
     * Created by Md. Jakir Hossain on 29/04/2019.
     *
     * @param title alert title
     * @param msg   alert message
     * @param icon  alert icon
     */
    fun showAlert(context: Context, title: String, msg: String, icon: Int) {
        val dialog: AlertDialog.Builder = AlertDialog.Builder(context)
        dialog.setTitle(title)
        dialog.setIcon(icon)
        dialog.setMessage(msg)
        dialog.setPositiveButton(
            android.R.string.ok
        ) { dialogInterface, _ ->
            dialogInterface.dismiss()
        }
        dialog.show()
    }
}