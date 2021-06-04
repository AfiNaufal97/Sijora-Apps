package com.bagkit.capstone.sijora.uiapps.activity.home

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.bagkit.capstone.sijora.R
import com.bagkit.capstone.sijora.databinding.ActivityHomeBinding
import com.bagkit.capstone.sijora.register.model.DataQueryTag
import com.bagkit.capstone.sijora.uiapps.activity.add.AddActivity
import com.bagkit.capstone.sijora.uiapps.activity.detail.DetailActivity
import com.bagkit.capstone.sijora.uiapps.activity.profile.ProfilleActivity
import com.bagkit.capstone.sijora.uiapps.adapter.AdapterHome
import com.google.firebase.database.*


class HomeActivity : AppCompatActivity(), Toolbar.OnMenuItemClickListener {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var firebaseReference:DatabaseReference
    private lateinit var dataIn:ArrayList<DataQueryTag>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataIn = arrayListOf<DataQueryTag>()
        logoutButton()
        addListener()
        setDataFirebase()
    }

    private fun setDataFirebase() {
        firebaseReference = FirebaseDatabase.getInstance().getReference("hastag")
        firebaseReference.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(tag in snapshot.children){
                        val data = tag.getValue(DataQueryTag::class.java)
                        if (data != null) {
                            dataIn.add(data)
                        }
                    }
                }
                setValueRv(dataIn)
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@HomeActivity, "Database Error", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setValueRv(dataIn: ArrayList<DataQueryTag>) {
        binding.rvHome.apply {
            val rvAdapter = AdapterHome(dataIn)
            adapter = rvAdapter
            layoutManager = LinearLayoutManager(this@HomeActivity)
            rvAdapter.setValueHashtag(object:AdapterHome.SetDataHashtag{
                override fun setDataHastag(data: DataQueryTag) {
                    startActivity(Intent(this@HomeActivity, DetailActivity::class.java)
                        .putExtra("name", data.nameTag)
                        .putExtra("query", data.query))
                }

            })
        }
    }

    private fun addListener() {
        binding.floatingAdd.setOnClickListener {
           startActivity(Intent(this, AddActivity::class.java))
        }
    }


    private fun logoutButton() {
        binding.toolbarHome.setOnMenuItemClickListener(this)
    }

    override fun onMenuItemClick(item: MenuItem): Boolean {
       when(item.itemId){
           R.id.btn_to_profile -> startActivity(Intent(this, ProfilleActivity::class.java))
       }
        return true
    }

}