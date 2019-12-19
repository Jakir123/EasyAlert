package com.jakir.cse24.easyalert

import android.util.Log

object EasyLog {
    /**
     * This method is for printing a [ERROR] log message on the system console
     * @author Md. Jakir Hossain on 02/05/2019.
     *
     * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    fun logE(tag: String, msg: String) {
        Log.e("Easy EasyAlert $tag", msg)
    }

    /**
     * This method is for printing a [DEBUG] log message on the system console
     * @author Md. Jakir Hossain on 02/05/2019.
     *
     * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    fun logD(tag: String, msg: String) {
        Log.d("Easy EasyAlert $tag", msg)
    }

    /**
     * This method is for printing a [INFO] log message on the system console
     * @author Md. Jakir Hossain on 19/12/2019.
     *
     * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    fun logI(tag: String, msg: String) {
        Log.i("Easy EasyAlert $tag", msg)
    }

    /**
     * This method is for printing a [WARNING] log message on the system console
     * @author Md. Jakir Hossain on 19/12/2019.
     *
     * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    fun logW(tag: String, msg: String) {
        Log.w("Easy EasyAlert $tag", msg)
    }

    /**
     * This method is for printing a [VERBOSE] log message on the system console
     * @author Md. Jakir Hossain on 19/12/2019.
     *
     * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    fun logV(tag: String, msg: String) {
        Log.v("Easy EasyAlert $tag", msg)
    }
}