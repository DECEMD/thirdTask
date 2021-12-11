package com.example.thirdtask

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso


class FindImage : AppCompatActivity() {
    lateinit var imView: ImageView
    lateinit var imViewMini: ImageView
    lateinit var edText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_image)
        imView = findViewById(R.id.imView)
        edText = findViewById(R.id.edImage)
        imViewMini = findViewById(R.id.imViewMini)

        //edText.setOnTouchListener { ->}
        imViewMini.setOnClickListener {
            if (edText.text.toString() != "") {
                Picasso.get()
                    .load(edText.text.toString())
                    .placeholder(R.drawable.ic_baseline_error_outline_24)
                    .error(R.drawable.ic_baseline_error_outline_24)
                    .into(imView)
            } else {
                imView.setImageResource(R.drawable.ic_baseline_error_outline_24)
                Toast.makeText(this, "Something wrong", Toast.LENGTH_SHORT).show()

            }
        }


    }
}

