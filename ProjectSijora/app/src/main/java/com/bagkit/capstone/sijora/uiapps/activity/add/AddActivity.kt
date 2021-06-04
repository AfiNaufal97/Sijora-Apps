package com.bagkit.capstone.sijora.uiapps.activity.add

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bagkit.capstone.sijora.databinding.ActivityAddBinding
import com.bagkit.capstone.sijora.register.model.DataQueryTag
import com.bagkit.capstone.sijora.uiapps.activity.home.HomeActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddBinding
    private lateinit var firebaseRealtime:FirebaseDatabase
    private lateinit var firebaseRefrence:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setNewInput()
    }

    private fun setNewInput() {
        binding.btnSaveInput.setOnClickListener {
            firebaseRealtime = FirebaseDatabase.getInstance()
            firebaseRefrence= firebaseRealtime.getReference("hastag")
            val newTag = binding.tvEdtNewTag.text.toString()
            val newQuery = binding.tvEdtNewQuery.text.toString()

            if(newTag.isEmpty()){
                binding.tvEdtNewTag.error ="Tidak Boleh Kosong bro"
            }
            if(newQuery.isEmpty()){
                binding.tvEdtNewQuery.error ="Tidak Boleh Kosong bro"
            }

            val add = DataQueryTag(newQuery, newTag)
            firebaseRefrence.child(newTag).setValue(add)
            Toast.makeText(this, "Succes Add New Sentiment", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }
}