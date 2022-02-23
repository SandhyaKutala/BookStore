
package com.example.bookstore

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager.widget.ViewPager
import com.example.bookstore.ProfileActivity.Companion.FIRST_NAME
import com.example.bookstore.ProfileActivity.Companion.LAST_NAME
import com.example.bookstore.ProfileActivity.Companion.SHAREDPREFERENCES
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.nav_header.view.*


class MainActivity : AppCompatActivity() {

  private lateinit var viewPager: ViewPager
  private lateinit var tabLayout: TabLayout
  private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
        setSupportActionBar(findViewById(R.id.toolbar))

        val actionBar : ActionBar? = supportActionBar

        actionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu)
        }

        val navigationView : NavigationView = findViewById(R.id.design_navigation_view)
        navigationView.setNavigationItemSelectedListener {
            menuItem ->
            when(menuItem.itemId){
                R.id.profile -> {
                    val intent = Intent(this@MainActivity,ProfileActivity::class.java)
                    startActivity(intent)

                }
                R.id.about ->{
                    val intent = Intent(this@MainActivity,AboutActivity::class.java)
                    startActivity(intent)

                }
            }
            drawerLayout.closeDrawers()
            true
        }

        viewPager = findViewById(R.id.view_pager)
        tabLayout = findViewById(R.id.tab_layout)

        val pagerAdapter = MyPagerAdapter(supportFragmentManager)
        viewPager.adapter = pagerAdapter

        tabLayout.setupWithViewPager(viewPager)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item?.itemId){
            android.R.id.home ->{

                val sharedPreferences = this.getSharedPreferences(SHAREDPREFERENCES, Context.MODE_PRIVATE)
                val firstName = sharedPreferences.getString(FIRST_NAME,"name")
                val lastName = sharedPreferences.getString(LAST_NAME,"lastname")
                drawerLayout.full_name.text = "$firstName$lastName"



                drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> return super.onOptionsItemSelected(item)

        }
    }
}