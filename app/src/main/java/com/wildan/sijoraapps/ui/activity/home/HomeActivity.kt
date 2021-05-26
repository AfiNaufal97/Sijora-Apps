package com.wildan.sijoraapps.ui.activity.home

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.wildan.sijoraapps.R
import com.wildan.sijoraapps.databinding.ActivityHomeBinding
import com.wildan.sijoraapps.ui.SectionsPagerAdapter

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    companion object {
        private val TAB_IMG = intArrayOf(
            R.drawable.ic_transport_white,
            R.drawable.ic_city_white,
            R.drawable.ic_medic_white,
            R.drawable.ic_electric_white,
            R.drawable.ic_voice_white,
            R.drawable.ic_school_white
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this)
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.setIcon(TAB_IMG[position])
        }.attach()
        supportActionBar?.elevation = 0f
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.search).actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = resources.getString(R.string.search)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                Toast.makeText(this@HomeActivity, query, Toast.LENGTH_SHORT).show()
                return true
            }
            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
        return true
    }
/*
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu1 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, MenuFragment())
                    .addToBackStack(null)
                    .commit()
                return true
            }
            R.id.menu2 -> {
                val i = Intent(this, MenuActivity::class.java)
                startActivity(i)
                return true
            }
            else -> return true
        }
    }*/
}