package com.hypersoft.clicker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hypersoft.clicker.databinding.ActivityMainBinding
import com.hypersoft.rapidclick.Extensions.rapidSafeClickListener

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShortToast.rapidSafeClickListener {
            Toasty.showShort(this, "This is a short Toast")
        }

        binding.btnLongToast.setOnClickListener {
            Toasty.showLong(this, "This is a long Toast")
        }

    }
}