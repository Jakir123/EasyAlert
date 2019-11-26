package com.jakir.cse24.easyalert

import android.content.Context
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

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
        val toast: Toast = Toast.makeText(context, msg, Toast.LENGTH_LONG)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
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
        dialog.setPositiveButton(android.R.string.ok
        ) { dialogInterface, _ ->
            dialogInterface.dismiss()
        }
        dialog.show()
    }
}