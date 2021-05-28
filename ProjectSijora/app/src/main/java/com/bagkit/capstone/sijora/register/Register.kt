package com.bagkit.capstone.sijora.register

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bagkit.capstone.sijora.MainActivity
import com.bagkit.capstone.sijora.databinding.ActivityRegisterBinding
import com.bagkit.capstone.sijora.register.model.DataUser
import com.bagkit.capstone.sijora.uiapps.activity.home.HomeActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Register : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth:FirebaseAuth
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        clickRegister()
    }

    override fun onResume() {
        super.onResume()
        if(firebaseAuth.currentUser != null){
            Intent(this, MainActivity::class.java).apply {
                this.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(this)
            }
        }
    }

    private fun createAccount(nama: String, username: String, email: String, password: String) {
        firebaseDatabase = FirebaseDatabase.getInstance()
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this){
                task -> if (task.isSuccessful){
            databaseReference = firebaseDatabase.getReference("detail user").child(firebaseAuth.currentUser!!.uid)
            val dbUser = DataUser(firebaseAuth.currentUser!!.uid, nama, username, email)
            databaseReference.setValue(dbUser)
            Toast.makeText(this,  "Register Succes", Toast.LENGTH_SHORT).show()
            Intent(this, HomeActivity::class.java).apply {
                this.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(this)
            }

        }else{
            Toast.makeText(this, "Gagal Register", Toast.LENGTH_SHORT).show()
        }

        }
    }

    private fun clickRegister() {
        firebaseAuth = FirebaseAuth.getInstance()
        binding.btnRegister.setOnClickListener {
            val nama = binding.edtName.text.toString()
            val username = binding.edtUsername.text.toString()
            val email = binding.edtEmailReg.text.toString()
            val password = binding.edtPassword.text.toString()
            if(nama.isEmpty()){
                binding.edtName.error = "Tidak Boleh Kosong"
            }

            if(username.isEmpty()){
                binding.edtUsername.error = "Tidak Boleh Kosong"
            }

            if(email.isEmpty()){
                binding.edtEmailReg.error = "Tidak Boleh Kosong"
            }

            if(password.isEmpty()){
                binding.edtPassword.error = "Tidak Boleh Kosong"
            }

            createAccount(nama, username, email, password)
        }
    }
}