package com.example.bookstore

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.ActionBar
import android.os.Bundle
import android.util.Log
import android.widget.Button
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_profile.*
import java.io.IOException

class ProfileActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var profileImage : CircleImageView
    private lateinit var saveButton: Button
    companion object{
        const val SHAREDPREFERENCES = "my sharedpreferences"
        const val FIRST_NAME = "firstname"
        const val LAST_NAME ="lastname"
        private const val SELECT_IMAGE = 1
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        sharedPreferences  = this.getSharedPreferences(SHAREDPREFERENCES, Context.MODE_PRIVATE) ?:return

        profileImage = findViewById(R.id.circle_image_view)
        saveButton = findViewById(R.id.save)

        setSupportActionBar(findViewById(R.id.include_about))

        val actionBar : ActionBar ? = supportActionBar
        actionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)

        }

        profileImage.setOnClickListener {

            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_IMAGE)

        }
        saveButton.setOnClickListener {

            with(sharedPreferences.edit()){
                putString(FIRST_NAME,first_name.text.toString())
                putString(LAST_NAME,last_name.text.toString())
                apply()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == SELECT_IMAGE) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    try {
                        val selectedImage = data.data
                        val yourSelectedImage =
                            BitmapFactory.decodeStream(contentResolver.openInputStream(selectedImage!!))
                        profileImage.setImageBitmap(yourSelectedImage)
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}