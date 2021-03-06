package com.example.thirdtask

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import java.util.*

class FindImage : AppCompatActivity() {
    private lateinit var nButton: Button
    lateinit var imView: ImageView
    lateinit var imViewMini: ImageView
    lateinit var edText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_image)
        imView = findViewById(R.id.imView)
        edText = findViewById(R.id.edImage)
        imViewMini = findViewById(R.id.imViewMini)
        nButton = findViewById(R.id.button)

        nButton.setOnClickListener{
            val intent = Intent(this, AdditionalTask::class.java)
            startActivity(intent)
        }

        imViewMini.setOnClickListener {
            if (edText.text.isNotEmpty()) {
                Picasso.get()
                    .load(edText.text.toString())
                    .placeholder(R.drawable.ic_baseline_error_outline_24)
                    .error(R.drawable.ic_baseline_error_outline_24)
                    .into(imView)
            } else {
                imView.setImageResource(R.drawable.ic_baseline_error_outline_24)
                Toast.makeText(this,
                    R.string.error_alert,
                    Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}

