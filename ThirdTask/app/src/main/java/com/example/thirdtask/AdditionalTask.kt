package com.example.thirdtask

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.StrictMode
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL
import kotlin.concurrent.thread

class AdditionalTask : AppCompatActivity() {

    lateinit var imView2: ImageView
    lateinit var imViewMini2: ImageView
    lateinit var edText2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_additional_task)

        imView2 = findViewById(R.id.imView2)
        edText2 = findViewById(R.id.edImage2)
        imViewMini2 = findViewById(R.id.imViewMini2)

        imViewMini2.setOnClickListener {
            if (edText2.text.isNotEmpty()){
                StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitNetwork().build())
                val bitmap = downloadBitmap(edText2.text.toString())
                imView2.setImageBitmap(bitmap)
            } else {
                imView2.setImageResource(R.drawable.ic_baseline_error_outline_24)
                Toast.makeText(this,
                    R.string.error_alert,
                    Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun downloadBitmap(imageUrl: String): Bitmap? {
        return try {
            val conn = URL(imageUrl).openConnection()
            conn.connect()
            val inputStream = conn.getInputStream()
            val bitmap = BitmapFactory.decodeStream(inputStream)
            inputStream.close()
            bitmap
        } catch (e: Exception) {
            Log.e("Log1", "Exception $e")
            null
        }
    }
}
