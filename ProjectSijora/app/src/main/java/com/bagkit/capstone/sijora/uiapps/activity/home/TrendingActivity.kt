package com.bagkit.capstone.sijora.uiapps.activity.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bagkit.capstone.sijora.backend.api.twitter.RetrofitTwitter
import com.bagkit.capstone.sijora.backend.modeltwitter.DataTwitter
import com.bagkit.capstone.sijora.backend.modeltwitter.ModelTwitter
import com.bagkit.capstone.sijora.databinding.ActivityTrendingBinding
import com.bagkit.capstone.sijora.uiapps.adapter.AdapterStartActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TrendingActivity : AppCompatActivity() {

    private lateinit var binding:ActivityTrendingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrendingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setApiTwitter()
        binding.toolbarStart.setNavigationOnClickListener{
            onBackPressed().also {
                finish()
            }
        }
    }

    private fun setApiTwitter() {
        RetrofitTwitter.api.getFromJakarta().enqueue(object:Callback<ModelTwitter<DataTwitter>>{
            override fun onResponse(
                call: Call<ModelTwitter<DataTwitter>>,
                response: Response<ModelTwitter<DataTwitter>>
            ) {
                if(response.isSuccessful){
                    val body = response.body()!!.data
                    setRecylerView(body)
                }
            }

            override fun onFailure(call: Call<ModelTwitter<DataTwitter>>, t: Throwable) {
               Toast.makeText(this@TrendingActivity, "Error", Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun setRecylerView(body: List<DataTwitter>) {
        binding.rvTrendingTwitter.apply {
            val AdapterTrending = AdapterStartActivity(body)
            adapter = AdapterTrending
            layoutManager = LinearLayoutManager(this@TrendingActivity)
        }
    }
}