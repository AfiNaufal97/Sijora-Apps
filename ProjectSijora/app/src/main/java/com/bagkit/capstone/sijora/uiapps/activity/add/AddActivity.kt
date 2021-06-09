package com.bagkit.capstone.sijora.uiapps.activity.add

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bagkit.capstone.sijora.backend.modelapi.DataSijora
import com.bagkit.capstone.sijora.backend.modelapi.ModelApiSingle
import com.bagkit.capstone.sijora.backend.api.new.ObjectRetrofit
import com.bagkit.capstone.sijora.databinding.ActivityAddBinding
import com.bagkit.capstone.sijora.uiapps.activity.home.HomeActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setNewInput()


        val intentId = intent.getIntExtra("id", 0)
        setView(intentId)

        binding.toolbarAdd.setNavigationOnClickListener{
            onBackPressed()
        }

    }

    private fun setView(id: Int) {
        when(id){
            1 -> {
                binding.btnSaveInput.visibility = View.GONE
                binding.btnUpdateInput.visibility = View.VISIBLE
                binding.toolbarAdd.title = "Update Data"
//                binding.tvTitleAdd.text = "Update Data"
                binding.btnUpdateInput.setOnClickListener {
                    updateData()
                }
            }
        }
    }

    private fun updateData() {
        val intentData = intent.getParcelableExtra<DataSijora>("data")
        binding.tvEdtNewTag.setText(intentData!!.input_mobile)

        val tag = binding.tvEdtNewTag.text.toString()
        if(tag.isEmpty()){
            binding.tvEdtNewTag.error = "Tidak boleh kosong"
        }

        ObjectRetrofit.api.editDataById(intentData.id, DataSijora(intentData.id, tag, intentData.output_negative, intentData.output_positive)).enqueue(object:Callback<ModelApiSingle<DataSijora>>{
            override fun onResponse(
                call: Call<ModelApiSingle<DataSijora>>,
                response: Response<ModelApiSingle<DataSijora>>
            ) {
                if(response.isSuccessful){
                    Toast.makeText(this@AddActivity, "Sukses", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ModelApiSingle<DataSijora>>, t: Throwable) {
                Toast.makeText(this@AddActivity, "Sukses", Toast.LENGTH_SHORT).show()
                Intent(this@AddActivity, HomeActivity::class.java).apply {
                    this.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(this)
                }
            }

        })
    }

    private fun setNewInput() {
        binding.btnSaveInput.setOnClickListener {
            val newTag = binding.tvEdtNewTag.text.toString()

            if(newTag.isEmpty()){
                binding.tvEdtNewTag.error ="Tidak Boleh Kosong bro"
            }

            val add = DataSijora(0,newTag,"","")

            ObjectRetrofit.api.postDataById(add).enqueue(object: Callback<ModelApiSingle<DataSijora>>{
                override fun onResponse(
                    call: Call<ModelApiSingle<DataSijora>>,
                    response: Response<ModelApiSingle<DataSijora>>
                ) {
                    Toast.makeText(this@AddActivity, "Ok", Toast.LENGTH_SHORT).show()
                    Intent(this@AddActivity, HomeActivity::class.java).apply {
                        this.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(this)
                    }
                }

                override fun onFailure(call: Call<ModelApiSingle<DataSijora>>, t: Throwable) {
                    Toast.makeText(this@AddActivity, "Sukses", Toast.LENGTH_SHORT).show()
                    Intent(this@AddActivity, HomeActivity::class.java).apply {
                        this.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(this)
                    }
                }

            })
        }
    }

}