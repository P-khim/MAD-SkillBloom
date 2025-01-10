package com.example.skillbloomapp.global

import android.content.Context
import android.content.SharedPreferences


class AppPref private constructor(){


    fun isLoggedIn(context: Context): Boolean {
        return getPref(context).getBoolean(KEY_IS_LOGGED_IN, false)
    }

    fun setLoggedIn(context: Context, value: Boolean) {
        getPref(context).edit().putBoolean(KEY_IS_LOGGED_IN, value).apply()
    }


    private fun getPref(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    companion object {

        private const val PREF_NAME = "SkillBloom"
        private const val KEY_IS_LOGGED_IN = "isLoggedIn"

        private var instance: AppPref? = null

        fun get(): AppPref {
            if(instance == null){
                instance = AppPref()
            }

            return instance!!
        }

    }
}