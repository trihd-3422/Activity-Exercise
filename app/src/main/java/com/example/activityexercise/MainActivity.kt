package com.example.activityexercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activityexercise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val receivedMessage = intent.getStringExtra("REPLY_KEY")
        if (receivedMessage != null){
            binding.textContent.text = receivedMessage
        } else {
            binding.textContent.text = "....."
        }

        binding.buttonSend.setOnClickListener {
            val messageSend: String = binding.editTextSend.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("SEND_KEY", messageSend)
            startActivity(intent)
        }
    }
}