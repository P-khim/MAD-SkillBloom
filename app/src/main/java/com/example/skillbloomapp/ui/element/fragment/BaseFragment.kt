package com.example.skillbloomapp.ui.element.fragment

import androidx.fragment.app.Fragment
import com.example.skillbloomapp.ui.element.activity.BaseActivity

open class BaseFragment:Fragment() {

    fun showLoading(){
        val hostActivity = activity as BaseActivity?
        hostActivity?.showLoading()
    }

    fun  hideLoading(){
        val hostActivity = activity as BaseActivity?
        hostActivity?.hideLoading()
    }

    fun showAlert(title: String, message : String){
        val hostActivity = activity as BaseActivity?
        hostActivity?.showAlert(title, message)
    }
}