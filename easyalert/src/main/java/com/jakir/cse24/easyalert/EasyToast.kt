package com.jakir.cse24.easyalert

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.custom_toast.view.*


class EasyToast {
    companion object {
        private val DEFAULT_TYPEFACE =
            Typeface.create("sans-serif-condensed", Typeface.NORMAL)
        private var toastTypeface = DEFAULT_TYPEFACE
        private var textSize = 14
        private var textColor = R.color.color_black
        private var hasToastIcon = false
        private var toastIcon = R.drawable.ic_check_white_24dp
        private var iconColor = R.color.color_white
        private var toastLength = Toast.LENGTH_LONG
        private var backgroundColor = R.color.color_grey
        private var toastPosition = Gravity.CENTER

        /**
         * This method is for showing message using android [Toast]
         * @author Md. Jakir Hossain on 29/04/2019.
         *
         * @param msg message which will display on screen
         */
        fun showToast(context: Context, msg: String) {
            val toast: Toast = customToast(
                context,
                msg,
                textColor,
                hasToastIcon,
                toastIcon,
                iconColor,
                backgroundColor
            )
            toast.show()
        }

        /**
         * This method is for showing message using android [Toast]
         * @author Md. Jakir Hossain on 29/04/2019.
         *
         * @param msg message which will display on screen
         */
        fun showToastWithIcon(context: Context, msg: String, icon: Int) {
            val toast: Toast = customToast(
                context,
                msg,
                R.color.color_black,
                true,
                icon,
                R.color.color_white,
                R.color.color_grey
            )
            toast.show()
        }

        /**
         * This function is for showing Info [Toast].
         * @author Md. Jakir Hossain on 18/12/2019.
         *
         * @param context application context.
         * @param msg message that should be shown in [Toast].
         */
        fun showInfoToast(context: Context, msg: String) {
            val toast: Toast = customToast(
                context,
                msg,
                R.color.color_white,
                true,
                R.drawable.ic_info_outline_white_24dp,
                R.color.color_white,
                R.color.color_info
            )
            toast.show()
        }

        /**
         * This function is for showing success [Toast].
         * @author Md. Jakir Hossain on 18/12/2019.
         *
         * @param context application context.
         * @param msg message that should be shown in [Toast].
         */
        fun showSuccessToast(context: Context, msg: String) {
            val toast: Toast = customToast(
                context,
                msg,
                R.color.color_white,
                true,
                R.drawable.ic_check_white_24dp,
                R.color.color_white,
                R.color.color_success
            )
            toast.show()
        }

        /**
         * This function is for showing Info [Toast].
         * @author Md. Jakir Hossain on 18/12/2019.
         *
         * @param context application context.
         * @param msg message that should be shown in [Toast].
         */
        fun showWarningToast(context: Context, msg: String) {
            val toast: Toast = customToast(
                context,
                msg,
                R.color.color_white,
                true,
                R.drawable.ic_warning_white_24dp,
                R.color.color_white,
                R.color.color_warning
            )
            toast.show()
        }

        /**
         * This function is for showing error [Toast].
         * @author Md. Jakir Hossain on 18/12/2019.
         *
         * @param context application [Context].
         * @param msg message which should be shown in [Toast].
         */
        fun showErrorToast(context: Context, msg: String) {
            val toast: Toast = customToast(
                context,
                msg,
                R.color.color_white,
                true,
                R.drawable.ic_error_white_24dp,
                R.color.color_white,
                R.color.color_error
            )
            toast.show()
        }

        /**
         * This function is for creating Custom [Toast]
         * @author Md. Jakir Hossain on 18/12/2019.
         *
         * @param context application [Context].
         * @param text message for showing in toast.
         * @param textColor message text color.
         * @param hasIcon is toast has icon or not.
         * @param icon icon id(int).
         * @param iconColor icon tint color.
         * @param bgColor toast background color.
         * @return an instance of [Toast].
         */
        private fun customToast(
            context: Context,
            text: CharSequence,
            textColor: Int,
            hasIcon: Boolean,
            icon: Int,
            iconColor: Int,
            bgColor: Int
        ): Toast {
            val layoutInflater = LayoutInflater.from(context)
            val layout =
                layoutInflater.inflate(
                    R.layout.custom_toast
                    , null
                ).findViewById<ConstraintLayout>(R.id.container)

            val backgroundDrawable = layout.background.current as GradientDrawable
            backgroundDrawable.setColor(ContextCompat.getColor(context, bgColor))
            if (hasIcon) {
                layout.imvIcon.setImageDrawable(ContextCompat.getDrawable(context, icon))
                layout.imvIcon.colorFilter = PorterDuffColorFilter(
                    ContextCompat.getColor(context, iconColor),
                    PorterDuff.Mode.SRC_IN
                )
            } else {
                layout.imvIcon.visibility = View.GONE
            }

            layout.tvMessage.setTextColor(ContextCompat.getColor(context, textColor))
            layout.tvMessage.text = text
            layout.tvMessage.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize.toFloat())

            val toast = Toast(context)
            toast.duration = toastLength
            toast.setGravity(toastPosition, 0, 0)
            toast.view = layout

            return toast
        }
    }

    class Customization private constructor() {

        fun setTypeface(typeface: Typeface): Customization {
            toastTypeface = typeface
            return this
        }

        fun setTextSize(sizeInSp: Int): Customization {
            textSize = sizeInSp
            return this
        }

        fun hasIcon(hasIcon: Boolean): Customization {
            hasToastIcon = hasIcon
            return this
        }

        fun setIcon(icon: Int): Customization {
            toastIcon = icon
            return this
        }

        fun setIconColor(color: Int): Customization {
            iconColor = color
            return this
        }

        fun setTextColor(color: Int): Customization {
            textColor = color
            return this
        }

        fun setToastLength(length: Int):Customization{
            toastLength = length
            return this
        }

        fun setBackgroundColor(color: Int):Customization{
            backgroundColor = color
            return this
        }

        fun setToastPosition(position:Int):Customization{
            toastPosition = position
            return this
        }


        companion object {
            val instance: Customization
                get() = Customization()

            fun reset() {
                toastTypeface = DEFAULT_TYPEFACE
                textSize = 16
                textColor = R.color.color_black
                hasToastIcon = false
                toastIcon = R.drawable.ic_check_white_24dp
                iconColor = R.color.color_white
                toastLength = Toast.LENGTH_LONG
                backgroundColor = R.color.color_grey
                toastPosition = Gravity.CENTER
            }
        }
    }

}