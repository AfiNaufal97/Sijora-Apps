package com.bagkit.capstone.sijora.uiapps.activity.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bagkit.capstone.sijora.databinding.ActivityProfilleBinding
import com.bagkit.capstone.sijora.register.Login
import com.bagkit.capstone.sijora.register.model.DataUser
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class ProfilleActivity : AppCompatActivity() {

    private lateinit var binding:ActivityProfilleBinding
    private lateinit var databaseReference: DatabaseReference
    private lateinit var containerData:ArrayList<DataUser>
    private lateinit var firebaseAuth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        containerData = arrayListOf<DataUser>()
        setLogout()

        binding.btnBack3.setOnClickListener {
            onBackPressed().apply {
                finish()
            }
        }
    }

    private fun setLogout(){
        firebaseAuth = FirebaseAuth.getInstance()
        if(firebaseAuth.currentUser != null){
            setFirebaseData(firebaseAuth.currentUser!!.uid)
            binding.btnLogout.setOnClickListener {
                firebaseAuth.signOut()
                Intent(this, Login::class.java).apply {
                    this.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(this)
                }
            }
        }
    }

    private fun setFirebaseData(id:String) {
       databaseReference = FirebaseDatabase.getInstance().getReference("detail user")
        databaseReference.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(value in snapshot.children){
                        val data = value.getValue(DataUser::class.java)
                        if(data!!.id == id){
                            setViewProfile(data)
                        }
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@ProfilleActivity, "Ada Error", Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun setViewProfile(value: DataUser?) {
        if(value != null){
            binding.tvName.text = value.name
            binding.tvName3.text = value.email
        }
    }
}