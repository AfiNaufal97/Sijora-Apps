package com.bagkit.capstone.sijora.uiapps.activity.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bagkit.capstone.sijora.R
import com.bagkit.capstone.sijora.backend.modelapi.DataSijora
import com.bagkit.capstone.sijora.backend.modelapi.ModelApiMultiple
import com.bagkit.capstone.sijora.backend.api.new.ObjectRetrofit
import com.bagkit.capstone.sijora.databinding.ActivityHomeBinding
import com.bagkit.capstone.sijora.uiapps.activity.about.AboutActivity
import com.bagkit.capstone.sijora.uiapps.activity.add.AddActivity
import com.bagkit.capstone.sijora.uiapps.activity.detail.DetailActivity
import com.bagkit.capstone.sijora.uiapps.activity.profile.ProfilleActivity
import com.bagkit.capstone.sijora.uiapps.adapter.AdapterHome
import com.google.firebase.database.DatabaseReference
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeActivity : AppCompatActivity(), Toolbar.OnMenuItemClickListener,
    androidx.appcompat.widget.Toolbar.OnMenuItemClickListener {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var firebaseReference: DatabaseReference
    lateinit var adapterList : AdapterHome

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id = intent.getIntExtra("id", 0)

        logoutButton()
        setApiData()
        addListener(id)

        setClickButton()

    }

    private fun setClickButton() {
        binding.floatingOpsi.setOnClickListener {
            binding.floatingAdd.visibility = View.VISIBLE
            binding.floatingClose.visibility = View.VISIBLE
            binding.floatingTrending.visibility = View.VISIBLE
            binding.floatingOpsi.visibility = View.GONE
        }
        binding.floatingClose.setOnClickListener {
            binding.floatingAdd.visibility = View.GONE
            binding.floatingClose.visibility = View.GONE
            binding.floatingTrending.visibility = View.GONE
            binding.floatingOpsi.visibility = View.VISIBLE
        }

        binding.floatingTrending.setOnClickListener {
            startActivity(Intent(this, TrendingActivity::class.java))
        }

    }


    private fun setApiData(){
       ObjectRetrofit.api.getData().enqueue(object: Callback<ModelApiMultiple<DataSijora>> {
           override fun onResponse(call: Call<ModelApiMultiple<DataSijora>>, response: Response<ModelApiMultiple<DataSijora>>?) {
                if(response!!.isSuccessful){
                    val bodyData = response.body()!!.Sijora
                        setRv(bodyData)
                        Toast.makeText(this@HomeActivity, "Ok", Toast.LENGTH_SHORT).show()
                        Log.d("Hallo", "Ok")
                }
           }

           override fun onFailure(call: Call<ModelApiMultiple<DataSijora>>, t: Throwable) {
            Toast.makeText(this@HomeActivity, "${t.message}", Toast.LENGTH_SHORT).show()
           }

       })
    }

    private fun setRv(bodyData: List<DataSijora>) {
        adapterList = AdapterHome(bodyData)
        binding.rvHome.apply {
            adapter = adapterList
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapterList.setValueHashtag(object:AdapterHome.SetDataHashtag{
                override fun setDataHastag(data: DataSijora) {
                    val data = DataSijora(data.id, data.input_mobile, data.output_negative, data.output_positive)
                    startActivity(Intent(this@HomeActivity, DetailActivity::class.java).putExtra("data", data))
                }

            })
        }
    }

    private fun addListener(id:Int) {
        when(id){
            1 -> {
                binding.floatingAdd.setOnClickListener {
                    startActivity(Intent(this, AddActivity::class.java))
                }
            }
            else -> binding.floatingAdd.visibility = View.GONE
        }
    }


    private fun logoutButton() {
        binding.toolbarHome.setOnMenuItemClickListener(this)
    }

    override fun onMenuItemClick(item: MenuItem): Boolean {
       when(item.itemId){
           R.id.btn_to_profile -> startActivity(Intent(this, ProfilleActivity::class.java))
           R.id.btn_about -> startActivity(Intent(this, AboutActivity::class.java))
       }
        return true
    }

}