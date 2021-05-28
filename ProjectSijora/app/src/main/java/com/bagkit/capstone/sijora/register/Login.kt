package com.bagkit.capstone.sijora.register

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bagkit.capstone.sijora.MainActivity
import com.bagkit.capstone.sijora.databinding.ActivityLoginBinding
import com.bagkit.capstone.sijora.uiapps.activity.home.HomeActivity
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setLogin()
        setToRegister()
    }

    override fun onResume() {
        super.onResume()
        if(firebaseAuth.currentUser != null){
            Intent(this, HomeActivity::class.java).apply{
                this.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(this)
            }
        }
    }

    private fun setToRegister() {
        binding.tvToRegister.setOnClickListener {
            startActivity(Intent(this, Register::class.java))
        }
    }

    private fun setLogin() {
        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnLogin.setOnClickListener {
            val email = binding.edtEmailLogin.text.toString()
            val password = binding.edtPassword.text.toString()

            if(email.isEmpty()){
                binding.edtEmailLogin.error = "tidak boleh kososng"
            }
            if(password.isEmpty()){
                binding.edtPassword.error = "tidak boleh kososng"
            }

            loginShow(email, password)
        }
    }

    private fun loginShow(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){
                task -> if(task.isSuccessful){
            Toast.makeText(this, "Berhasil Masuk", Toast.LENGTH_SHORT).show()
            Intent(this, HomeActivity::class.java).apply {
                this.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(this)
            }
        }else{
            Toast.makeText(this, "Gagal Masuk", Toast.LENGTH_SHORT).show()
        }
        }
    }
}