package com.jakir.cse24.easyalert

import android.app.AlertDialog
import android.content.Context
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.drawable.GradientDrawable
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.custom_toast.view.*


object EasyAlert {
    /**
     * This method is for showing error/warning using alert dialog.
     * @author Md. Jakir Hossain on 29/04/2019.
     *
     * @param title alert title.
     * @param msg   alert message.
     * @param icon  alert icon.
     */
    fun showAlert(context: Context, msg: String, title: String = "Easy EasyAlert",  icon: Int = android.R.drawable.ic_dialog_alert) {
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