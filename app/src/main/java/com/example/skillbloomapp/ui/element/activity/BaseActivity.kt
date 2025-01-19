package com.example.skillbloomapp.ui.element.activity

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.skillbloomapp.R

open class BaseActivity : AppCompatActivity() {

    private var progressDialog: Dialog? = null

    override fun onDestroy() {
        super.onDestroy()
        // Ensure the dialog is dismissed to prevent memory leaks
        hideLoading()
    }

    fun showLoading() {
        if (progressDialog == null) {
            progressDialog = Dialog(this).apply {
                setContentView(R.layout.dialog_loading)
                setCancelable(false)
            }
        }

        if (!isFinishing && !isDestroyed) {
            progressDialog?.show()
        }
    }

    fun hideLoading() {
        if (progressDialog?.isShowing == true) {
            progressDialog?.dismiss()
        }
        progressDialog = null
    }

    fun showAlert(title: String, message: String) {
        if (!isFinishing && !isDestroyed) {
            val dialog = AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null)
                .create()
            dialog.show()
        }
    }
}
