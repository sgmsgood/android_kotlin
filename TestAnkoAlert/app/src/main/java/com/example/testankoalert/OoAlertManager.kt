package com.example.testankoalert

import android.app.Activity
import androidx.appcompat.app.AlertDialog

object OoAlertManager {

    private var dialog: AlertDialog? = null

    var isAllowDuplicate = false

    fun init(isAllowDuplicate: Boolean) {
        this.isAllowDuplicate = isAllowDuplicate
    }

    fun confirm(
        activity: Activity,
        message: String,
        buttonTitle: String,
        listener: OnDialogListener?
    ) {
        if (!isAllowDuplicate) {
            if (dialog != null) {
                dialog?.dismiss()
            }
        }

        dialog = AlertDialog.Builder(activity).apply {
            setMessage(message)
            setPositiveButton(buttonTitle) { _, _ ->
                listener?.let { it() }
            }
            setCancelable(false)
            create()
        }.show()
    }


    fun alert(
        activity: Activity,
        message: String,
        positiveTitle: String,
        negativeTitle: String,
        positiveListener: OnDialogListener?,
        negativeListener: OnDialogListener?
    ) {
        AlertDialog.Builder(activity).apply {
            setMessage(message)
            setPositiveButton(positiveTitle) { _, _ ->
                positiveListener?.let { it() }
            }
            setNegativeButton(negativeTitle) { _, _ ->
                negativeListener?.let { it() }
            }
            setCancelable(false)
            create()
        }.show()
    }
}

typealias OnDialogListener = (() -> Unit)