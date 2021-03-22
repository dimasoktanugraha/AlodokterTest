package com.dimas.alodokter.core.data

import android.content.Context
import android.content.SharedPreferences

class SessionManager(private val context: Context) {

    companion object {
        const val ACCOUNT_HAS_LOGIN = "ACCOUNT_HAS_LOGIN"
        const val ACCOUNT_EMAIL = "ACCOUNT_EMAIL"
        const val ACCOUNT_PASS = "ACCOUNT_PASS"
    }

    private var pref: SharedPreferences = context.applicationContext.getSharedPreferences("Session", Context.MODE_PRIVATE)
    private var editor: SharedPreferences.Editor = pref.edit()

    //SETTER
    fun setAccount(email: String, pass: String) {
        editor.putString(ACCOUNT_EMAIL, email)
        editor.putString(ACCOUNT_PASS, pass)
        editor.putBoolean(ACCOUNT_HAS_LOGIN, true)
        editor.apply()
    }


    //GETTER
    fun hasLogin() = pref.getBoolean(ACCOUNT_HAS_LOGIN, false)

    fun getEmail() = pref.getString(ACCOUNT_EMAIL, "")

    fun getPass() = pref.getString(ACCOUNT_PASS, "")



    //CLEAR
    fun clearAccount(){
        editor.remove(ACCOUNT_EMAIL)
        editor.remove(ACCOUNT_PASS)
        editor.remove(ACCOUNT_HAS_LOGIN)
        editor.apply()
    }

}