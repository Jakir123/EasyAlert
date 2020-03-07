package com.jakir.cse24.easyalert

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.view.View
import android.widget.TextView


object EasyAlert {

    private var dialog: AlertDialog? = null

    /**
     * This method is for showing error/warning using [AlertDialog].
     * @author Md. Jakir Hossain on 29/04/2019.
     *
     * @param title alert title.
     * @param msg   alert message.
     * @param icon  alert icon.
     */
    fun showAlert(
        context: Context,
        msg: String,
        title: String = "EasyAlert",
        icon: Int = android.R.drawable.ic_dialog_alert
    ) {
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

    /**
     * This method is for showing progress dialog with message using [AlertDialog].
     * @author Md. Jakir Hossain on 7/03/2020.
     *
     * @param context activity reference.
     * @param message progress dialog message.
     */
    fun showProgressDialog(context: Activity, message: String) {
        showProgressDialog(context, message, true)
    }

    /**
     * This method is for showing progress dialog without message using [AlertDialog].
     * @author Md. Jakir Hossain on 7/03/2020.
     *
     * @param context activity refernce.
     */
    fun showProgressDialog(context: Activity) {
        showProgressDialog(context, "", false)
    }

    /**
     * This method is for showing progress dialog with message using [AlertDialog].
     * @author Md. Jakir Hossain on 7/03/2020.
     *
     * @param context activity reference.
     * @param message progress dialog message.
     * @param isMessageAvailable is for showing or hiding message textview.
     */
    private fun showProgressDialog(
        context: Activity,
        message: String,
        isMessageAvailable: Boolean
    ) {
        val layoutInflater = context.layoutInflater
        val view = layoutInflater.inflate(R.layout.progress_dialog, null)
        val tvMessage = view.findViewById<TextView>(R.id.tvProgressMessage)
        if (isMessageAvailable) {
            tvMessage.text = message
        } else {
            tvMessage.visibility = View.GONE
        }
        val alert = AlertDialog.Builder(context)
        alert.setCancelable(false).setView(view)
        dialog?.dismiss()
        dialog = alert.create()
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog?.show()
    }

    /**
     * This method is for hide/clear progress dialog
     * Created by Md. Jakir Hossain on 7/03/2020.
     */
    fun hideProgressDialog() {
        dialog?.dismiss()
        dialog = null
    }

}