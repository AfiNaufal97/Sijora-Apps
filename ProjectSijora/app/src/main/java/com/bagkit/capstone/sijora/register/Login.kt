package com.bagkit.capstone.sijora.register

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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
            if(firebaseAuth.currentUser!!.email == "naufal.setiawan92@gmail.com" || firebaseAuth.currentUser!!.email == "wildan@gmail.com" || firebaseAuth.currentUser!!.email == "bangkit2021@mail.com") {
                startActivity(Intent(this, HomeActivity::class.java)
                    .putExtra("id", 1)).also {
                        finish()
                }
            }else{
                startActivity(Intent(this, HomeActivity::class.java)
                    .putExtra("id", 2)).also {
                    finish()
                }
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
            if(email == "naufal.setiawan92@gmail.com" || email == "wildan@gmail.com" || email == "bangkit2021@mail.com"){
                startActivity(Intent(this, HomeActivity::class.java)
                    .putExtra("id", 1))
            }else{
                startActivity(Intent(this, HomeActivity::class.java)
                    .putExtra("id", 2))
            }
        }else{
            Toast.makeText(this, "Gagal Masuk", Toast.LENGTH_SHORT).show()
        }
        }
    }
}