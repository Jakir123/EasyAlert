package com.jakir.cse24.easyalert

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.graphics.Typeface
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class EasyAlert {
    companion object {
        private var dialog: AlertDialog? = null
        private val DEFAULT_TYPEFACE =
            Typeface.create("sans-serif-condensed", Typeface.NORMAL)
        private var alertTypeface = DEFAULT_TYPEFACE
        private var isDarkTheme = false
        var isProgressShowing = false

        /**
         * This method is for showing error/warning using [AlertDialog].
         * @author Md. Jakir Hossain on 29/04/2019.
         *
         * @param context application/activity [Context]
         * @param title alert dialog title.
         * @param msg   alert dialog message.
         * @param icon  alert dialog icon.
         * @return [Boolean] true if press on ok otherwise false
         */
        fun showAlert(
            context: Context,
            title: String? = null,
            msg: String,
            icon: Int? = null
        ) : MutableLiveData<Boolean>{
            return showAlert(context,msg,title,icon,false)
        }

        /**
         * This method is for showing error/warning using [AlertDialog].
         * @author Md. Jakir Hossain on 25/03/2020.
         *
         * @param context application/activity [Context]
         * @param title alert dialog title.
         * @param msg   alert dialog message.
         * @param icon  alert dialog icon.
         * @return [Boolean] true if press on ok otherwise false
         */
        fun showAlertWithChoice(
            context: Context,
            title: String? = null,
            msg: String,
            icon: Int? = null
        ): MutableLiveData<Boolean> {
            return showAlert(context,msg,title,icon,true)
        }

        /**
         * This method is for showing error/warning using [AlertDialog].
         * @author Md. Jakir Hossain on 25/03/2020.
         *
         * @param context application/activity [Context]
         * @param title alert dialog title.
         * @param msg   alert dialog message.
         * @param icon  alert dialog icon.
         * @param isChoice for adding cancel button.
         * @return [Boolean] true if user press ok, otherwise false.
         */
        private fun showAlert(
            context: Context,
            msg: String,
            title: String? = null,
            icon: Int? = null,
            isChoice:Boolean
        ): MutableLiveData<Boolean> {
            val response = MutableLiveData<Boolean>()
            try {
                val style = if (isDarkTheme)  R.style.alertStyle else R.style.alertStyle
                val dialog = MaterialAlertDialogBuilder(context)
                title.let { dialog.setTitle(it) }
                dialog.setMessage(msg)
                icon?.let { dialog.setIcon(it) }
                dialog.setPositiveButton(
                    android.R.string.ok
                ) { dialogInterface, _ ->
                    response.value = true
                    dialogInterface.dismiss()
                }
                if (isChoice){
                    dialog.setCancelable(false)
                    dialog.setNegativeButton(android.R.string.cancel) { dialogInterface, i ->
                        response.value = false
                        dialogInterface.dismiss()
                    }
                }
                dialog.show()
            }catch (ex: Exception){
                print(ex)
            }

            return response
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
         * @param context activity reference.
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
            activity: Activity,
            message: String,
            isMessageAvailable: Boolean
        ) {
            try {
                val layoutInflater = activity.layoutInflater
                val view = layoutInflater.inflate(R.layout.progress_dialog, null)
                val tvMessage = view.findViewById<TextView>(R.id.tvProgressMessage)
                if (isMessageAvailable) {
                    tvMessage.text = message
                } else {
                    tvMessage.visibility = View.GONE
                }
                val alert = AlertDialog.Builder(activity)
                alert.setCancelable(false).setView(view)
                dialog?.dismiss()
                dialog = alert.create()
//        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
                dialog?.show()

                isProgressShowing = true
            }catch (ex: Exception){
                print(ex)
            }
        }

        /**
         * This method is for hide/clear progress dialog
         * Created by Md. Jakir Hossain on 7/03/2020.
         */
        fun hideProgressDialog() {
            try {
                dialog?.dismiss()
                isProgressShowing = false
            }catch (ex: Exception){
                print(ex)
            }finally {
                dialog = null
            }
        }
    }

    class Customization private constructor() {

        fun setTypeface(typeface: Typeface): Customization {
            alertTypeface = typeface
            return this
        }

        fun setTheme(isDark: Boolean):Customization{
            isDarkTheme = isDark
            return this
        }


        companion object {
            val instance: Customization
                get() = Customization()

            fun reset() {
                alertTypeface = DEFAULT_TYPEFACE
                isDarkTheme = false
            }
        }
    }

}