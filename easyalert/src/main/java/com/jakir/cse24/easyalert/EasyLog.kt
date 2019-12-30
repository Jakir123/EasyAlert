package com.jakir.cse24.easyalert

import android.util.Log

object EasyLog {
    /**
     * This method is for printing a [ERROR] log message on the system console
     * @author Md. Jakir Hossain on 02/05/2019.
     *
     * @param msg The message you would like logged.
     * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
     */
    fun logE(msg: String, tag: String = "") {
        Log.e("EasyAlert $tag", msg)
    }

    /**
     * This method is for printing a [DEBUG] log message on the system console
     * @author Md. Jakir Hossain on 02/05/2019.
     *
     * @param msg The message you would like logged.
     * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
     */
    fun logD(msg: String, tag: String="") {
        Log.d("EasyAlert $tag", msg)
    }

    /**
     * This method is for printing a [INFO] log message on the system console
     * @author Md. Jakir Hossain on 19/12/2019.
     *
     * @param msg The message you would like logged.
     * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
     */
    fun logI(msg: String, tag: String="") {
        Log.i("EasyAlert $tag", msg)
    }

    /**
     * This method is for printing a [WARNING] log message on the system console
     * @author Md. Jakir Hossain on 19/12/2019.
     *
     * @param msg The message you would like logged.
     * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
     */
    fun logW(msg: String, tag: String="") {
        Log.w("EasyAlert $tag", msg)
    }

    /**
     * This method is for printing a [VERBOSE] log message on the system console
     * @author Md. Jakir Hossain on 19/12/2019.
     *
     * @param msg The message you would like logged.
     * @param tag Used to identify the source of a log message. It usually identifies the class or activity where the log call occurs.
     */
    fun logV(msg: String, tag: String = "") {
        Log.v("EasyAlert $tag", msg)
    }
}