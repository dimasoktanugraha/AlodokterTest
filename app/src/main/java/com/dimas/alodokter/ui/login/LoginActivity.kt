package com.dimas.alodokter.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import com.dimas.alodokter.core.data.SessionManager
import com.dimas.alodokter.databinding.ActivityLoginBinding
import com.dimas.alodokter.ui.main.MainActivity
import com.google.android.material.textfield.TextInputEditText
import org.koin.android.ext.android.inject

class LoginActivity : AppCompatActivity() {

    private val sessionManager: SessionManager by inject()
    private lateinit var binding: ActivityLoginBinding

    override fun onStart() {
        super.onStart()
        if(sessionManager.hasLogin()){
            moveToMain()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener {
            val email = binding.loginEmail.text?.trim().toString()
            val pass = binding.loginPass.text?.trim().toString()

            if (email.isEmpty()){
                setError(binding.loginEmail, "Email Kosong")
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                setError(binding.loginEmail, "Email tidak sesuai")
                return@setOnClickListener
            }
            if (pass.isEmpty()){
                setError(binding.loginPass, "Password Kosong")
                return@setOnClickListener
            }
            if (pass.length<6){
                setError(binding.loginPass, "Password kurang dari 6 karakter")
                return@setOnClickListener
            }

            sessionManager.setAccount(email, pass)
            moveToMain()
        }
    }

    private fun moveToMain() {
        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        finish()
    }

    private fun setError(loginEmail: TextInputEditText, error: String) {
        loginEmail.apply {
            setError(error, null)
            requestFocus()
        }
    }

}