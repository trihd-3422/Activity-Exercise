package com.example.activityexercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activityexercise.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val receivedMessage = intent.getStringExtra("SEND_KEY")
        if (receivedMessage != null){
            binding.textContent.text = receivedMessage
        } else {
            binding.textContent.text = "....."
        }

        binding.buttonReply.setOnClickListener {
            val messageSend: String = binding.editTextReply.text.toString()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("REPLY_KEY", messageSend)
            startActivity(intent)
        }
    }
}