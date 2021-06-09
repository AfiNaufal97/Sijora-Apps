package com.bagkit.capstone.sijora.uiapps.activity.detail

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.provider.ContactsContract
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bagkit.capstone.sijora.backend.modelapi.DataSijora
import com.bagkit.capstone.sijora.backend.api.new.ObjectRetrofit
import com.bagkit.capstone.sijora.databinding.ActivityDetailBinding
import com.bagkit.capstone.sijora.register.model.DataQueryTag
import com.bagkit.capstone.sijora.uiapps.activity.add.AddActivity
import com.bagkit.capstone.sijora.uiapps.activity.analysis.AnalysisActivity
import com.bagkit.capstone.sijora.uiapps.activity.home.HomeActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var firebaseReference:DatabaseReference
    private lateinit var firebaseAuth:FirebaseAuth
    companion object{
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_COUNT = "extra_count"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        firebaseAuth = FirebaseAuth.getInstance()

        if(firebaseAuth.currentUser!!.email == "naufal.setiawan92@gmail.com" || firebaseAuth.currentUser!!.email == "wildan@gmail.com" || firebaseAuth.currentUser!!.email == "bangkit2021@mail.com"){
            setClickMenu(1)
        }else{
            setClickMenu(2)
        }

//        firebaseReference = FirebaseDatabase.getInstance().getReference("hastag")

        val intent = intent.getParcelableExtra<DataSijora>("data")
        binding.tvDetailTitle.text = intent!!.input_mobile

        binding.imgViewBack.setOnClickListener {
            onBackPressed().also {
                finish()
            }
        }

        binding.btnDeleteFloatDetail.setOnClickListener {
            setDelete(intent)
        }

        binding.btnEditFloatDetail.setOnClickListener {
            setEdit(intent)
        }

        binding.btnAnalysis.setOnClickListener {
            Handler().postDelayed({
                val dataSent = DataSijora(intent.id, intent.input_mobile, intent.output_negative, intent.output_positive)
                startActivity(Intent(this, AnalysisActivity::class.java).putExtra("data", dataSent))
                binding.progresToResult.visibility = View.GONE
            },3000)
            binding.progresToResult.visibility = View.VISIBLE
        }
    }

    private fun setEdit(intent: DataSijora) {
        val data = DataSijora(intent.id, intent.input_mobile, intent.output_negative, intent.output_positive)
        startActivity(Intent(this, AddActivity::class.java)
            .putExtra("id", 1)
            .putExtra("data", data))
    }

    private fun setDelete(nama: DataSijora) {
        ObjectRetrofit.api.deleteDataById(nama.id).enqueue(object: Callback<Void>{
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                Toast.makeText(this@DetailActivity, "Sukses", Toast.LENGTH_SHORT).show()
                Intent(this@DetailActivity, HomeActivity::class.java).apply {
                    this.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(this)
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(this@DetailActivity, "Sukses", Toast.LENGTH_SHORT).show()
                Intent(this@DetailActivity, HomeActivity::class.java).apply {
                    this.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(this)
                }
            }

        })
    }

    private fun setClickMenu(id:Int) {
        when(id){
            1 -> {
                binding.btnMenuFloatDetail.setOnClickListener {
                    binding.btnMenuFloatDetail.visibility = View.GONE
                    binding.btnCloseFloatDetail.visibility = View.VISIBLE
                    binding.btnEditFloatDetail.visibility = View.VISIBLE
                    binding.btnDeleteFloatDetail.visibility = View.VISIBLE
                }

                binding.btnCloseFloatDetail.setOnClickListener {
                    binding.btnCloseFloatDetail.visibility = View.GONE
                    binding.btnEditFloatDetail.visibility = View.GONE
                    binding.btnDeleteFloatDetail.visibility = View.GONE
                    binding.btnMenuFloatDetail.visibility = View.VISIBLE
                }
            }
            else -> {
                binding.btnMenuFloatDetail.visibility = View.GONE
            }
        }
    }

}