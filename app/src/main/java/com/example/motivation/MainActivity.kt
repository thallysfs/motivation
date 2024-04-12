package com.example.motivation

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Infle a view e obtenha o objeto de binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)  // Use a view root do binding

        setContentView(R.layout.activity_main)

        // esconder barra de navegação
        supportActionBar?.hide()

        handleUserName()

        // Eventos
        binding.buttonNewPhrase.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view != null) {
            if(view.id == R.id.button_new_phrase){
                var s = ""
                print("teste!!!")
            }
        }
    }

    private fun handleUserName() {
        // resgata nome no sharedPreferences
        val name = SecurityPreference(this).getString("USER_NAME")
        val helloText = getString(R.string.hello_user, name)
        println(helloText)// Use resource string with placeholder
        binding.textUserName.text = helloText
    }
}